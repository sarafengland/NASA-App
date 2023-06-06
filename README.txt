NASA App
This app is an Android application that fetches information about the Apollo 11 mission from the NASA search API using Retrofit and displays the data in cards using the MVVM architecture.

Once the app is installed and launched, it will automatically fetch data from the NASA API using the hardcoded criteria. The fetched information will be displayed in cards on the main screen. Each card will contain details such as a title, an associated image, and a description. Users can scroll up to 10 cards.

Features
- Fetches information from the NASA API given some search criteria.
- Displays the fetched data in a visually appealing card format.
- Follows the MVVM (Model-View-ViewModel) architectural pattern.
- Uses Retrofit library for making API calls to the NASA API.
- Provides a clean and modular code structure.

Prerequisites
- Android Studio 4.1 or above.
- Android SDK with minimum API level 33 installed.
- Internet connection to fetch data from the NASA API.

Installation
- Clone the repository or download the source code.
- Open the project in Android Studio.
- Build the project to resolve dependencies.
- Connect an Android device or emulator with minimum API level 33.
- Run the app on the connected device/emulator.

Dependencies
- Retrofit: A type-safe HTTP client for making API calls.
- Gson: A library for converting JSON responses to Java/Kotlin objects.
- ViewModel and LiveData: Part of the Android Architecture Components for implementing MVVM pattern.
- RecyclerView: A flexible view for displaying a collection of data items.
- You can find the complete list of dependencies in the project's build.gradle file.

Limitations and future improvements
- The app has currently the search criteria hardcoded. A possible improvement would be to have the user enter the search criteria using text and/or filters.
- The app is currently limited to search only up to 10 items. A possible improvement could be to add the functionality to display more items as the user scrolls.
- The app currently does a single API call on start and there is no way for the user to try again other than closing and reopening the app. Adding this would improve the user experience.
- The app does not have any unit testing currently. Addition would improve and guarantee quality of the app.
