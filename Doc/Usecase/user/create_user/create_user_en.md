## Title: Creating a User
### Actors:
System Administrator

### Description:
The system administrator should have the ability to create new users within the system.

### Data:
First name, Last name, Email

### Preconditions:
The system administrator has access rights and authentication credentials to log in to the system.

### Main flow of events:
1. The server validates the incoming data.
2. The server saves the user data to the database.
3. The email confirmation scenario is triggered.

### Alternative flows:
- If the data does not pass validation, an error is returned.
- If the email address already exists, an error is returned.

### Postconditions:
A new user is successfully created within the system and saved in the database.

```mermaid
graph TB
    A[System Admin] --> A1(Tries to create a new user) --> B{Validate Data}
    B -- Success --> C[Save Data to Database]
    B -- Failure --> Y[Return Error]
    C --> D[TRIGGER EMAIL CONFIRMATION]
