# M1

## List of issues

### Issue 1: [NO LOG OUT BUTTON]

**Description**:[If a user wants to switch accounts, they would have to log out first. But the app has no log out button, the only way currently is to delete your account]

**How it was fixed?**: [Found the file where the buttons for profile management were made, mimicked everything (functions and callbacks) and just basically copied the delete account's infrastructure. Added it to the AccountSection composable since it's more similar to deleting account since nothing is edited. After that, copy pasted delete account's functions in Navigation.kt since that's where the error triggered when I was testing the app and created a handleLogout() function for NavigationStateManager]

-------------------------------------------------------
### Issue 2: [DELETE ACCOUNT DOESN'T WORK]

**Description**:[After deleting your account, it should follow that all your data is deleted and when remaking an account with the same email you would have to sign up and sign in again. When I deleted the account, I could just sign back in and all my data was still the same.]

**How it was fixed?**: [The backend API had the appropriate API endpoint to delete the user account, so it was a problem with the frontend. I changed AuthViewModel's handleAccountDeletion() to also delete the account on the server side. The frontend didn't access the delete API endpoint, and so I also needed to implement that and everything in the middle. Now, none of the data is saved after deletion.]

-------------------------------------------------------
### Issue 3: [BIO CANNOT BE CHANGED]

**Description**:[When editing your profile, clicking on the bio doesn't allow users to edit it. Seems like a flaw.]

**How it was fixed?**: [Simply went to ManageProfileScreen to find what allows for bio to be edited. Saw it was read-only=true, changed it to false and also removed the "Row" wrapper that had canFocus = false property]

-------------------------------------------------------
### Issue 4: [PROFILE PICTURE DOES NOT STAY CHANGED]

**Description**:[When managing your profile, you can change your profile picture by either taking a picture using the camera or uploading an image. However, once you are done editing your profile and close the page it reverts back to your previous profile picture.]

**How it was fixed?**: [In the logcat, it showed the request header and only the name and bio was in them so I had to add a field for the profilePicture variable. Once I figured that out, I simply added a profilePicture parameter in the ]

-------------------------------------------------------
### Issue 5: [NAME INPUT CAN BE VERY LONG]

**Description**:[When inputting something to be your profile name, the length can be extremely long. It should be limited to a certain number of characters.]

**How it was fixed?**: [Simply limit the input character length in the manage profile section. I chose 20, this prevents anyone from inputting more than 20 and so there need not be any changes to other files.]