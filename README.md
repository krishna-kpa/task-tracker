# Task Tracker - Requirement Document

Task Tracker is a project used to track and manage your tasks. This project is a **Command-Line Interface (CLI) application** that helps users keep track of their tasks—what needs to be done, what is in progress, and what has been completed. Once the application is started then it will be a commandline interface in which users can execute commands and achieve their needs.

---

## 📌 Features

### 📝 Task Management
- **Add a task**
- **Update a task**
- **Delete a task**
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
- Users should receive **WhatsApp notifications before 1 hr of the deadline**.

---

## 💡 Example Usage

### 📌 Task Management Commands
# Adding a new task
```
add -n <task name> -d <dead line date time> -s <status>
```
### Output: Task added successfully - {task}

# Updating and deleting tasks
-n, -d, and -s are optional options for the user.
```
update 1 -n <input task name> -d <input dead line date time> -s <input status>
delete 1
```
### Output: Task Updated/ Deleted successfully - {task}

# Listing all tasks
```
list
```
### Output: List of Tasks

# Listing tasks by status
```
list done
list todo
list in-progress
```
### Output: List of Tasks

## 🔐 User Authentication
### Login
users can login with the help of the below command
```
login -u <user name> -p <password>
login -phone <phone number> -p <password>
```
### Logout
users can log out with the help of the below command.
```
logout
```
### Register
users can register with the help of the below command
```
register -u <user name> -n <name> -p <password> -phone <phone number>
-- <otp>
```
### Who AM I
users can get the current user who logged in using the following command.
```
whoami
```

