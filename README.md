# Kotlin-JetPack-Compose-with-Firebase-authentication

<div align="center">
  <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRr3wDZhPXZtsJqOEkHBAYesol0Vq5si3b5YbcbiYaLJA&s=10" alt="Android Jetpack Compose" width="120">
  <img src="https://www.gstatic.com/devrel-devsite/prod/v77395b06d4e5653b4783307683b5dfbe4eb7cf793540c1e8f26db9dd5ba70220/firebase/images/touchicon-180.png" alt="Firebase Logo" width="110">

  # Kotlin Jetpack Compose × Firebase Auth

  <p align="center">
    <strong>A production-ready Android architectural template showcasing modern Login, Registration, and Password Reset workflows built entirely with Jetpack Compose and Firebase Authentication.</strong>
    <br />
    <br />
    <a href="#-key-features">Explore Features</a>
    ·
    <a href="https://github.com/username/Kotlin-JetPack-Compose-with-Firebase-authentication/issues/new?labels=bug">Report Bug</a>
    ·
    <a href="https://github.com/username/Kotlin-JetPack-Compose-with-Firebase-authentication/issues/new?labels=enhancement">Request Feature</a>
  </p>
</div>

---

<div align="center">

[![Android Platform](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/)
[![Kotlin Version](https://img.shields.io/badge/Kotlin-2.0.0-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Compose-Material3-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)](https://developer.android.com/compose)
[![Firebase Auth](https://img.shields.io/badge/Firebase-Authentication-FFCA28?style=for-the-badge&logo=firebase&logoColor=black)](https://firebase.google.com/)

</div>

---

## 📷 UI Showcase

Here is a visual breakdown of the application user flows built with modern Material 3 design principles:

<div align="center">
  <table border="0">
    <tr>
      <td align="center" width="33%">
        <strong>1. Welcome Screen</strong><br/><br/>
        <img src="https://images.unsplash.com/photo-1616469829581-73993eb86b02?q=80&w=400&auto=format&fit=crop" width="240" alt="Welcome Screen Preview"/><br/>
        <sub>Clean entry point with brand vector styling.</sub>
      </td>
      <td align="center" width="33%">
        <strong>2. Secure Authorization</strong><br/><br/>
        <img src="https://images.unsplash.com/photo-1563986768609-322da13575f3?q=80&w=400&auto=format&fit=crop" width="240" alt="Login Screen Preview"/><br/>
        <sub>Real-time validation feedback fields.</sub>
      </td>
      <td align="center" width="33%">
        <strong>3. Dynamic Home State</strong><br/><br/>
        <img src="https://images.unsplash.com/photo-1551288049-bebda4e38f71?q=80&w=400&auto=format&fit=crop" width="240" alt="Dashboard Preview"/><br/>
        <sub>Authenticated persistent user session layout.</sub>
      </td>
    </tr>
  </table>
</div>


---

## 🚀 Key Features

* **🔐 Full Auth Lifecycle:** Out-of-the-box support for Email/Password registration, Login, Password Reset, and explicit secure Logout.
* **⚡ Modern Jetpack Compose UI:** 100% declarative UI components styled cleanly using the latest `Material3` design standards.
* **🏗️ Clean Architecture:** Separation of concerns using unidirectional data flow (UDF) with **ViewModel**, **StateFlow**, and **Repository** patterns.
* **🛡️ Input Validation Engine:** Live interactive state reporting for email regex conformity and password strength requirements.
* **🌀 Persistent Sessions:** Auto-route users directly to the Dashboard if an authenticated active Firebase user token is detected on launch.

---

## 🛠️ Tech Stack & Architecture

- **Language:** [Kotlin](https://kotlinlang.org/)
- **UI Framework:** [Jetpack Compose](https://developer.android.com/compose)
- **Design Language:** Material Design 3 (M3)
- **Backend Infrastructure:** [Firebase Auth SDK](https://firebase.google.com/docs/auth)
- **Asynchronous Flow:** Kotlin Coroutines & `StateFlow`
- **Dependency Injection:** Hilt / Dagger (Optional / Ready)

```
app
 └── src/main/java/com/example/firebaseauth
      ├── data
      │    └── repository      # Firebase Auth Service implementation
      ├── ui
      │    ├── screens         # Login, Register, Home, ForgotPassword screens
      │    ├── components      # Reusable Custom TextFields, Buttons, Loaders
      │    └── theme           # Material3 Colors, Typography, and Shapes
      ├── viewmodel            # AuthViewModel handling reactive app states
      └── MainActivity.kt      # App entry point with NavHost Controller
```

---

## 📦 Getting Started

To get this Firebase template compiled locally on your workstation, walk through these configuration steps:

### 1. Prerequisites
- Android Studio Koala / Ladybug or newer.
- An active [Firebase Console](https://console.firebase.google.com/) project.

### 2. Connect Your Firebase Instance
1. Open the Firebase Console and click **Add Project**.
2. Register an Android Application using your exact project package name (e.g., `com.example.firebaseauth`).
3. Download your generated `google-services.json` file.
4. Move this file directly into your local project root folder inside the app module: `/app/google-services.json`.

### 3. Activate the Authentication Service
1. In the Firebase Left Sidebar navigation menu, click **Build** ➜ **Authentication**.
2. Under the **Sign-in method** tab, activate the **Email/Password** provider toggle.

### 4. Build and Run
Clone and sync gradle directly to launch the application:
```bash
# Clone the repository
git clone https://github.com/username/Kotlin-JetPack-Compose-with-Firebase-authentication.git

# Navigate into the project folder
cd Kotlin-JetPack-Compose-with-Firebase-authentication
```
Run an absolute project rebuild within Android Studio and deploy onto an active device or emulator.

---

## 🤝 Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create.

1. **Fork** the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. **Commit** your Changes (`git commit -m 'Add some AmazingFeature'`)
4. **Push** to the Branch (`git push origin feature/AmazingFeature`)
5. Open a **Pull Request**

---

## 📄 License

Distributed under the MIT License. See `LICENSE` for more information.
