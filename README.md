## Basic Info:

Final Project for CSCI 201 Summer 2020.

Designed and created the UI/UX mainly bootstrap. The sources for graphics are listed below:

* Logo source: https://www.flaticon.com/free-icon/pet-house_3047827?term=pet&page=1&position=53

* Vector images: https://undraw.co/search

* Icons: https://fontawesome.com/v4.7.0/icons/ and https://www.flaticon.com/

* Bootstrap registration/login forms: https://bootstrapious.com/

# Information routing:

## For adopter and shelter

If a user isn't logged in, the default page will be `pickRegister.html`, but if they are logged in, the default page is main.html

## Registration process for adopter

If a user picked `I want to adopt a pet`, they'll be routed to `adoptRegister.html`. After they submit "Create your account", they'll be routed to `adopterRegisterPreferences.html` where they fill out their preferences for the pets. Upon submitting the second form, they'll be routed to `main.html` where they can start swiping

## Main.html

In `main.html`, there are 3 tabs
* main page (`main.html`) - for swiping
* messages (`chat.html`) - for chatting with shelter for specific pet
* edit preferences (`edit.html`)- to update preferences

### Swiping

The basic info that'll display for swiping are pet name, shelter name, city, species, size, and age. There will be 3 icons below: baby, dog, cat. Each of them indicates if the pet is friendly with any of those. If a pet is friendly with all 3 of them, all 3 of the icons will display. If a pet is only friendly with baby, only the baby icon will display.

At the bottom, there is a check and cross mark. Clicking on check will allow user to start messaging with the shelter in messaging tab. Clicking on the cross will remove the pet from user's preferences list


### Messages

Should be fairly straight forward and easy to follow on how to include java code to make it work.

In the messaging layout, when clicking on the profile pic, it should redirect to `profile.html` where it'll show the profile of the current pet. The profile layout is same as the one you see in `main.html` except there's no check marks
