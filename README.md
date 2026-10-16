## 🎯 About The Project

**FitClassHub** is a simple and efficient Java desktop application built to streamline operations for fitness centers and gyms. It allows admins or trainers to manage member registrations, schedule fitness classes, track class enrollments, and generate billing invoices without requiring a complex database setup.

---

## ✨ Key Features

- 👥 **Member Management:** Add, view, update, and track fitness center members.
- 🧘 **Class Scheduling:** Organize and manage fitness classes (e.g., Yoga, HIIT, Strength Training).
- 🧾 **Invoice Generation:** Generate and maintain billing records for members and class bookings.
- 📁 **File-Based Data Persistence:** Automatically reads and saves operational data using structured text files (`members.txt`, `classes.txt`, `invoices.txt`).

---

## 🛠️ Tech Stack

- **Language:** Java (JDK 8+)
- **IDE Support:** Eclipse IDE (includes `.classpath` and `.project` settings)
- **Data Persistence:** Flat Text Files (`.txt`)

---

## 📂 Project Structure

```text
FitClassHub/
├── bin/            # Compiled Java bytecode (.class files)
├── src/            # Java source code (.java files)
├── .classpath      # Eclipse Java Build Path configuration
├── .project        # Eclipse project configuration file
├── .gitignore      # Ignored files for Git version control
├── classes.txt     # Data store for fitness classes
├── invoices.txt    # Data store for member billing & invoices
├── members.txt     # Data store for registered gym members
└── README.md       # Project documentation
