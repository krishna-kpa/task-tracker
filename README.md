# Task Tracker - Requirement Document

Task Tracker is a project used to track and manage your tasks. This project is a **Command-Line Interface (CLI) application** that helps users keep track of their tasks—what needs to be done, what is in progress, and what has been completed. 

---

## 📌 Features

### 📝 Task Management
- **Add a task**
- **Update a task**
- **Delete a task**
- **Mark a task as in progress or done**
- **List all tasks**
- **Filter tasks by status** (`todo`, `in-progress`, `done`)  

### 🔐 User Authentication
- **User registration**
- **Login & Logout** using a secure authentication mechanism

### 🔔 WhatsApp Notifications
- **Task reminders** via WhatsApp for upcoming deadlines  

---

## ⚙️ Requirements

- The application **must run from the command line**.
- User actions and inputs **should be passed as command-line arguments**.
- **Tasks must be stored in a MongoDB database**.
- **Authentication and authorization must be implemented**.
- Users should receive **WhatsApp notifications for upcoming tasks**.

---

## 💡 Example Usage

### 📌 Task Management Commands
# Adding a new task
 add "Buy groceries"
# Output: Task added successfully (ID: 1)

# Updating and deleting tasks
 update 1 "Buy groceries and cook dinner"
 delete 1

# Marking a task as in progress or done
 mark-in-progress 1
 mark-done 1

# Listing all tasks
 list

# Listing tasks by status
 list done
 list todo
 list in-progress

## 🔐 User Authentication

### Register a new user
```sh
task-cli register --username krishna --password mysecurepassword
Login
sh
Copy
Edit
task-cli login --username krishna --password mysecurepassword
Logout
sh
Copy
Edit
task-cli logout
🔔 WhatsApp Notifications
Enable WhatsApp notifications for tasks
sh
Copy
Edit
task-cli notify --enable
Disable notifications
sh
Copy
Edit
task-cli notify --disable
