# 🏠 HomeSettings

An ongoing full-stack project for managing smart IoT devices in a household — built with **Next.js** on the frontend and **Kotlin** on the backend.

> 🔐 Focused on privacy and secure access — so guests don't peek at your cameras.

---

## 🔧 Tech Stack

* **Frontend**: Next.js (React-based)
* **Backend**: Kotlin + Ktor
* **Authentication**: JWT (JSON Web Tokens)
* **Security**: CORS policies, guest-user restrictions
* **Database**: PostgreSQL

---

## ✨ Features (Implemented)

* User registration & login with JWT-based auth
* Role-based access (Owner vs Guest)
* Secure CORS setup between frontend/backend

## 🏗 Features (Planned)

* Device dashboard (lights, thermostat, cameras)
* Role-based device control
* Logging and alerts
* Admin UI for access control

---

## 🚀 Running the App

### Frontend (Next.js)

```bash
cd frontend
npm install
npm run dev
# http://localhost:3000
```

### Backend (Kotlin - Ktor)

```bash
cd backend
./gradlew run
# http://localhost:8080
```

### Database (PostgreSQL)

Make sure PostgreSQL is running locally or accessible via network.

Set the following environment variables in a `.env` file or `application.conf`:

```env
DB_URL=jdbc:postgresql://localhost:5432/homesettings
DB_USER=your_username
DB_PASSWORD=your_password
JWT_SECRET=your_jwt_secret
```

---

## 🛡 Security Notes

* Authentication via JWT
* CORS restricted to known origins
* Guest users have **no access to sensitive devices** (e.g., cameras)

---

## 📌 Status

> 🚧 Project is **under active development** — core auth is complete.

---

## 🙌 Credits

Built with love and security-first mindset. 💡🔒



