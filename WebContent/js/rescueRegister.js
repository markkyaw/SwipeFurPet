// Changing input group text on focus
$(function () {
    $('input, select').on('focus', function () {
        $(this).parent().find('.input-group-text').css('border-color', '#80bdff');
    });
    $('input, select').on('blur', function () {
        $(this).parent().find('.input-group-text').css('border-color', '#ced4da');
    });
});

// Check if all entries are filled
document.querySelector('form').onsubmit = function()
{
  let name = document.getElementById("name").value.trim();
  let id = document.getElementById("id").value.trim();
  let email = document.getElementById("email").value.trim();
  let phone = document.getElementById("phoneNumber").value.trim();

  if (name.length == 0)
  {
    document.getElementById("name-invalid").classList.add("is-invalid");
    document.getElementById("name-invalid").innerHTML = "Please enter organization name";
  }
  else
  {
    document.getElementById("name-invalid").classList.remove("is-invalid");
    document.getElementById("name-invalid").innerHTML = "";
  }

  if (id.length == 0)
  {
    document.getElementById("id-invalid").classList.add("is-invalid");
    document.getElementById("id-invalid").innerHTML = "Please enter organization id";
  }
  else
  {
    document.getElementById("id-invalid").classList.remove("is-invalid");
    document.getElementById("id-invalid").innerHTML = "";
  }

  if (email.length == 0)
  {
    document.getElementById("email-invalid").classList.add("is-invalid");
    document.getElementById("email-invalid").innerHTML = "Please enter an email";
  }
  else
  {
    document.getElementById("email-invalid").classList.remove("is-invalid");
    document.getElementById("email-invalid").innerHTML = "";
  }

  if (phone.length == 0)
  {
    document.getElementById("phone-invalid").classList.add("is-invalid");
    document.getElementById("phone-invalid").innerHTML = "Please enter your phone number";
  }
  else
  {
    document.getElementById("phone-invalid").classList.remove("is-invalid");
    document.getElementById("phone-invalid").innerHTML = "";
  }
  
  
  return (!document.querySelectorAll('.is-invalid').length > 0 );
}