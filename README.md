

Created By Jordan Tsvetanov

Android applicaiton containing welcome message. 

Underneath there are two buttons. The top one sends and 
explicit intend and starts an activity (text editor). 
The user can enter text in the editor and press the Press button.
The implented Pattern Matcher is looking for a phone number 
in the following formats:
(888)888-8888, (888) 888-8888 or 888-8888.
if a phone number is found an implicit intent is sent to the 
dialer with ACTION_DIAL. 

When the text editor activity is done it sends back a result
to the main activity.


When the user presses the bottom button, an implicit intent starts an
activity(browser) which opens up the android main website.
