# Musikt – Apple Music API for Kotlin

```
// Retrieve an artist by ID:
val a = AppleMusic.getArtist("178834") // returns an Artist instance
println(a.name)                        // prints "Bruce Springsteen"
println(a.genreNames.joinToString())   // prints "Rock"
```

Musikt utilizes Kotlin coroutines to retrieve data from the API asynchronously without using callbacks/futures/rx.
All the functions requesting external resources are suspending.

## Getting started

In order to use the Apple Music API, you need to generate a private key on the Apple Developer website. 
[Read more...](https://developer.apple.com/library/content/documentation/NetworkingInternetWeb/Conceptual/AppleMusicWebServicesReference/SetUpWebServices.html)

Before your application starts making requests to the API, set up your Team ID and private key:
```
Credentials.teamID = "team"
Credentials.privateKey = "key"
```