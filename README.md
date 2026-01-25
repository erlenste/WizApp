# The Ultimate Wizard App

## Content

### Components
- **MainScreen** is the main component of MainActivity.kt
- **DropdownMenu** contains an ExposedDropdownMenuBox with ExposedDropdownMenu Items that exposes an callback function
- **LoadingComponent** contains a CircularProgressIndicator that spins when rendered 
- **ResultComponent** contains a LazyVerticalStaggeredGrid which renders either SpellCard og WizardCard composables

### API
Fetches data from [WizardWorldApi](https://github.com/MossPiglets/WizardWorldAPI?tab=readme-ov-file)

Check out the [Swagger](https://wizard-world-api.herokuapp.com/swagger/index.html)

### HTTP Client
This example uses the [Ktor Client](https://ktor.io/docs/client-create-new-application.html#create-client) to make HTTP requests

### Dependency Injection
This app utilizes [Hilt](https://dagger.dev/hilt/) for providing the necessary dependencies.

Check out [Android with Hilt docs](https://developer.android.com/training/dependency-injection/hilt-android) on Android Developer for more tips and tricks.


### Overview of app
<img width="2924" height="3684" alt="WizAppArch (1)" src="https://github.com/user-attachments/assets/07c61668-4d57-4762-96b6-bfd07012bb69" />

## TODO
- Implement WizViewModel containing a UiState for Wizards or Spells
- Use WizViewModel to fetch data from WizDataSource
- Handle response from the data source, and manage the UiState
- Show the state of result, isLoading and isError in MainScreen if they are available in the WizViewModel
