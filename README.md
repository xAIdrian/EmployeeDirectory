### Focus Areas

Coding up this quick project I focused on sticking with what is popular within Android recommended frameworks.  Choosing MVVMs because we would be making a request whose return time was unknown.  MVVM would allow us to emit the result of our single query to update the UI in a reactive way.  Following the rule of seperation of concerns we integrated our ViewModel with a Repository to keep the task of making requests isolated from the business functionality of the app.

### Copied Dependencies

We copied the code in for `SingleLiveEvent` from the AOSP.  We could have gone without it and stuck with MutableLiveData for our error and loading events but I like it because it only emits a single value when called.  Using MutableLiveData we run the risk of getting into awkward states with events that affect the UI because when our ViewModel is instantiated we are instantiating the MutableLiveDatas with them whose defualt behavior is to emit a single default values when they come into existence.

#### Focused on phone using the emulator on my computer

#### Spent about 3 hours on the project
