# M1

## New Feature

**Name:** [Dad Joke Button]

**Short description:** [A dad joke button can be pressed in the Main screen to fetch a random dad joke from an external dad joke API.]

**Location and code:** [The location of the function that presents it to the frontend is in MainScreen.kt, inside MainBody(). The logic side is in MainViewModel.kt, while the actual API endpoint fetch is in a new file called JokeInterface.kt. RetrofitClient has also been edited to create a new endpoint base, and a data type was created to parse the API's response -- called JokeResponse.]
