# 💰 Expenses Manager App  
A modern, clean and fast personal finance tracker built using **Kotlin**, **MVVM**, **Room Database**, **Koin DI**, and **Material 3 UI**.  
Track your **income, expenses, wallet balance**, and stay organized with a beautiful UI.

---

## 📱 Screenshots


---

## 🚀 Features

### 🧮 Expense & Income Tracking
- Add income or expense entries  
- Categorize transactions  
- Auto-calculate totals:  
  - **Total Income**  
  - **Total Expense**  
  - **Wallet Balance**

### 📊 Dashboard / Home Screen
- Clean and modern summary cards  
- Wallet balance overview  
- Income vs Expense  
- Scrollable list of all transactions  

### ➕ Add Transaction Screen
- Smooth category input  
- Date picker  
- Notes  
- Income/Expense toggle  
- Input validations  

### ⚙️ Settings
- Displays email & UID (future-ready for auth)  
- Logout button  

### 🌗 Auto Dark / Light Mode
- App theme changes based on system theme  
- Clean Material 3 styling  

---

## 🛠 Tech Stack

| Layer | Technology |
|------|------------|
| UI | XML + Material 3 |
| Logic | Kotlin, Coroutines, Flows |
| Architecture | MVVM |
| Dependency Injection | **Koin** |
| Local DB | Room Database |
| Navigation | Android Jetpack Navigation |
| Design | Custom shapes, elevation, cards |

---

## 📂 Project Structure

```
app/
 ├── data/
 │    ├── db/ (Room database)
 │    ├── dao/ (ExpenseDao)
 │    ├── model/ (Expense.kt)
 │    └── repository/
 │
 ├── ui/
 │    ├── home/
 │    ├── add/
 │    ├── settings/
 │    └── splash/
 │
 ├── viewmodel/
 │
 ├── di/ (Koin modules)
 │
 ├── utils/
 │
 └── App.kt  (Koin initialization)
```

---

## 💾 Database Design (Room)

### Table: `Expense`
| Column | Type |
|--------|------|
| id | Int (Primary Key) |
| amount | Int |
| category | String |
| type | String ("income" / "expense") |
| date | Long |
| note | String |

---

## ✔️ Requirements
- **Android Studio Ladybug or later**
- **Min SDK 26**
- **Kotlin 1.9+**
- **Material 3**

---

## 🚧 Future Enhancements
- Firebase Auth  
- Cloud Backup  
- Expense Graphs (Pie Chart, Bar Chart)  
- Monthly filtering  
- Export to PDF  

---

## 📥 Installation (APK)
You can download the APK from:

👉 `Releases` (once you upload)

---

## 🤝 Contributing
Feel free to contribute!  
Pull requests are welcome.

---


---

## 👨‍💻 Developer

**Atharv Urunkar**  
Android Developer  
Portfolio coming soon 😉

---

# ⭐ If you found this helpful, give the repo a star!

