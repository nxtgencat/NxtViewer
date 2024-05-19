# My Android Development Tech Stack

## 1. Kotlin
Kotlin is the primary language used for Android development. It offers modern language features and improved syntax over Java.

## 2. Android Jetpack Components
### Jetpack Compose
Jetpack Compose is used for building the UI. It simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.

### Room
Room provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.

### ViewModel
ViewModel is designed to store and manage UI-related data in a lifecycle-conscious way. It allows data to survive configuration changes such as screen rotations.

### LiveData
LiveData is an observable data holder class. It respects the lifecycle of other app components, such as activities, fragments, or services, ensuring that LiveData updates app component observers only when they are in an active lifecycle state.

### Lifecycle
Lifecycle-aware components help you create better-organized, and often lighter-weight code that is easier to maintain.

## 3. Dependency Injection
### Hilt
Hilt is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project. Hilt automatically provides bindings for standard Android classes such as Application, Activity, and Fragment.

## 4. Asynchronous Programming
### Coroutines
Coroutines are used for asynchronous programming, making it easier to manage background threads and tasks.
