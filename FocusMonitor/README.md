# Focus Monitor

Focus Monitor is an Android application designed to simulate focus monitoring and BLE (Bluetooth Low Energy) device communication. The app uses modern Android development tools and best practices, including Jetpack Compose, Hilt, and Coroutines.

## Features

- **Focus Score Simulation**: Generates a random focus score between 0 and 100, updated every 5 seconds.
- **Start/Stop Monitoring**: Allows users to start or stop focus monitoring using a toggle button.
- **BLE Simulation**: Simulates scanning and connecting to BLE devices.
- **Modern UI**: Built using Jetpack Compose for a responsive and declarative user interface.
- **Dependency Injection**: Utilizes Hilt for clean and modular code.
- **Asynchronous Programming**: Uses Kotlin Coroutines for non-blocking operations.

## Project Structure

```plaintext
FocusMonitor/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/focusmonitor/
│   │   │   │   ├── presentation/
│   │   │   │   │   ├── vm/                  # ViewModels
│   │   │   │   │   ├── ui/                  # UI Composables
│   │   │   ├── AndroidManifest.xml
│   │   ├── test/                            # Unit tests
│   │   ├── androidTest/                     # Instrumented tests
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
```

## Getting Started

### Prerequisites

- Android Studio Flamingo or newer
- Kotlin 1.8 or higher
- Gradle 8.0 or higher

### Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd FocusMonitor
   ```

2. Open the project in Android Studio.

3. Sync the Gradle files and build the project.

4. Run the app on an emulator or a physical device.

## Testing

### Unit Tests
Unit tests are located in the `src/test` directory. You can run them with:
```bash
./gradlew testDebugUnitTest
```

### Instrumented Tests
Instrumented tests are located in the `src/androidTest` directory. You can run them with:
```bash
./gradlew connectedAndroidTest
```

## Technologies Used

- **Jetpack Compose**: Modern toolkit for building native Android UI.
- **Kotlin Coroutines**: Asynchronous programming.
- **Hilt**: Dependency injection.
- **JUnit**: Unit testing framework.
- **Turbine**: Testing Flow emissions.
