# 🧳 Triply Quotes App

Triply Quotes is a simple Jetpack Compose mobile app that displays a simulated travel quote for a trip.

---

## 📱 Features
- Jetpack Compose UI
- Fetches quote data from a **remote API (GitHub Gist)**
- MVVM architecture
- Retrofit for HTTP requests
- Loading state handling

---

## 📷 Sample Data
Displayed travel quote includes:
- Destination: **Mombasa**
- Travel Date: **August 15, 2024**
- Number of Travellers: **2**
- Total Cost: **KES 150,000**
- A beach image from Unsplash

---

## 🌐 API Source: GitHub Gist

This project fetches the quote data from a **public GitHub Gist** served via its **raw link**. This simulates a public API response without needing a real backend.

### 🧾 JSON Content in Gist
```json
{
  "destination": "Mombasa",
  "travelDate": "August 15, 2024",
  "travellers": 2,
  "totalCost": "KES 150,000",
  "imageUrl": "https://images.unsplash.com/photo-1507525428034-b723cf961d3e"
}
```

### ✅ How the Gist is Integrated:
- The **raw Gist URL** is used as the endpoint in Retrofit.
- `ApiService.kt` defines the GET path based on the Gist's structure:
  ```kotlin
  @GET("username/gist-id/raw/quote.json")
  suspend fun getSampleQuote(): Quote
  ```
- Retrofit `baseUrl` is set to:
  ```kotlin
  "https://gist.githubusercontent.com/"
  ```

---

## 🧱 Project Structure
```
com.example.tripquote
├── data
│   ├── model          # Quote data class
│   ├── remote         # Retrofit API service
│   └── repository     # QuoteRepository
├── ui
│   ├── screens        # Jetpack Compose screens
│   ├── theme          # Colors and typography
│   └── viewmodel      # QuoteViewModel
├── navigation         # NavGraph setup
└── MainActivity.kt    # App entry point
```

---

## 🛠️ Tech Stack
- Kotlin
- Jetpack Compose
- Retrofit + Gson
- MVVM Architecture
- GitHub Gist (as remote API)

---

## 🚀 Setup Instructions
1. Clone the repo
2. Replace the Gist URL in `ApiService.kt` with your own if needed
3. Build and run the project using Android Studio (with Jetpack Compose support)

---

## 📌 Notes
- The app uses a **remote Gist file** instead of local assets to meet the API simulation requirement
