function test()
{
    console.log("test");
}

document.querySelector("form").onsubmit = function()
{
    let message = document.querySelector("#msg").value.trim();

    if (message.length == 0)
    {
        document.querySelector(".checkMsg").classList.add("is-invalid");
    }
    else
    {
        document.querySelector(".checkMsg").classList.remove("is-invalid");
    }

    return (!document.querySelectorAll('.is-invalid').length > 0 );
}

window.onload = function() {
    var profiles = document.querySelectorAll('.profile');
    for(var i = 0; i < profiles.length; i++) {
        var p = profiles[i];
        p.onclick = function() {
            document.querySelector(".hiddenForm").submit();
        }
    }
}

window.onload = function() {
    var chats = document.querySelectorAll('.chats');
    for(var i = 0; i < chats.length; i++) {
        chats[i].onclick = function() {
            for (var j = 0; j < chats.length; j++)
            {
                chats[j].classList.remove("active");
                chats[j].classList.remove("text-white");
                chats[j].classList.add("list-group-item-light");
            }
            this.classList.add("active");
            this.classList.add("text-white");
            this.classList.remove("list-group-item-light");
        }    
    }
}

window.onload = function() {
    var form = document.querySelectorAll('.hiddenForm');
    for(var i = 0; i < form.length; i++) {
        form[i].onclick = function() {
            // console.log(this.firstElementChild.value);
            this.submit();
        }    
    }
}

document.querySelector(".sendMsg").onclick = function()
{
    let message = document.querySelector("#msg").value.trim();

    console.log(message);

    if (message.length == 0)
    {
        document.querySelector(".checkMsg").classList.add("is-invalid");
    }
    else
    {
        document.querySelector(".checkMsg").classList.remove("is-invalid");
    }

    if (!document.querySelector(".checkMsg").classList.contains("is-invalid"))
    {
        let box = document.querySelector(".mainChat");
        let media = document.createElement("div");
        media.classList.add("media", "w-50", "ml-auto", "mb-3");

        let mediaBody = document.createElement("div");
        mediaBody.classList.add("media-body");

        let bgPrimary = document.createElement("div");
        bgPrimary.classList.add("bg-primary", "rounded", "py-2", "px-3", "mb-2");

        let pTag = document.createElement("p");
        pTag.classList.add("text-small", "mb-0", "text-white");
        pTag.innerHTML = message;

        let pTag1 = document.createElement("p");
        pTag1.classList.add("small", "text-muted");
        
        let d = new Date();
        dateTime = d.getFullYear() + "-" + d.getMonth().pad() + "-" + d.getDate().pad() + " " + d.getHours().pad() + ":" + d.getMinutes().pad() + ":" + d.getSeconds().pad();

        pTag1.innerHTML = dateTime;

        bgPrimary.appendChild(pTag);
        mediaBody.appendChild(bgPrimary);
        mediaBody.appendChild(pTag1);
        media.appendChild(mediaBody);
        box.appendChild(media);

        document.querySelector(".msgPreview").innerHTML = message;
        document.querySelector("#msg").value = "";

        // let jsObject = {
        //     userEmail: document.querySelector(".hiddenUserEmail").innerHTML, 
        //     petID: document.querySelector(".getPetID").value, 
        //     content: message, 
        //     timestamp: dateTime,
        //     userSend: 1
        // };

        // console.log(jsObject);

        $.ajax({
            method:"POST",
            url:"chatServlet",
            data: {
                userEmail: document.querySelector(".hiddenUserEmail").innerHTML, 
                petID: document.querySelector(".getPetID").value, 
                content: message, 
                timestamp: dateTime,
                userSend: 1
            }
        });
    }
}

Number.prototype.pad = function(size) {
    var s = String(this);
    while (s.length < (size || 2)) {s = "0" + s;}
    return s;
}