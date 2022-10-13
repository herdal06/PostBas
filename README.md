<h1 align="center">PostBase</h1>

<p align="center">  
This is a basic Android application that shows posts and their details, user comments on posts and user profiles, based on MVVM architecture.
<br/>
<p align="center">I used <a href="https://dummyjson.com/">DummyJson</a> for building this application.</p>
</p>

#### App Screenshots

| Home | Post Details | User Details |
|:-:|:-:|:-:|
| ![Fist](https://github.com/herdal06/PostBase/blob/master/screenshots/home.png?raw=true) | ![3](https://github.com/herdal06/PostBase/blob/master/screenshots/post_details.png?raw=true) | ![3](https://github.com/herdal06/PostBase/blob/master/screenshots/on_click_user.png?raw=true)
| Home Dark Mode | Post Details Dark Mode | User Details Dark Mode |
| ![4](https://github.com/herdal06/PostBase/blob/master/screenshots/home_dark.png?raw=true) | ![5](https://github.com/herdal06/PostBase/blob/master/screenshots/post_details_dark.png?raw=true) | ![3](https://github.com/herdal06/PostBase/blob/master/screenshots/on_click_user_dark.png?raw=true)


<img src="/arts/rickandmorty.gif" align="right"  width="24%"/>

## Tech stack
* ✅ MVVM with Clean Architecture
* ✅ [Kotlin Flow][31] - In coroutines, a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value.
* ✅ [Coroutines][51] - A concurrency design pattern that you can use on Android to simplify code that executes asynchronously.
* ✅ [Navigation Component][24] - Handle everything needed for in-app navigation. asynchronous tasks for optimal execution.
* ✅ [Safe-Args][25] - For passing data between destinations
* ✅ [Dagger-Hilt][93] - A dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.
* ✅ [ViewModel][17] - Easily schedule asynchronous tasks for optimal execution.
* ✅ [Retrofit][90]- Retrofit is a REST client for Java/ Kotlin and Android by Square inc under Apache 2.0 license. Its a simple network library that is used for network transactions. By using this library we can seamlessly capture JSON response from web service/web API.
* ✅ [OkHttp][23] - Doing HTTP efficiently makes your stuff load faster and saves bandwidth.
* ✅ [Coil][92] - An image loading library for Android backed by Kotlin Coroutines
* ✅ [View Binding][11] - a feature that allows you to more easily write code that interacts with views.
* ✅ [Lifecycle][22] - As a user navigates through, out of, and back to your app, the Activity instances in your app transition through different states in their lifecycle.


[11]: https://developer.android.com/topic/libraries/view-binding
[92]: https://coil-kt.github.io/coil/
[93]: https://developer.android.com/jetpack/compose/libraries#hilt
[51]: https://developer.android.com/kotlin/coroutines
[90]: https://square.github.io/retrofit/
[31]: https://developer.android.com/kotlin/flow
[22]: https://developer.android.com/guide/components/activities/activity-lifecycle
[17]: https://developer.android.com/jetpack/compose/state#viewmodel-state
[23]: https://square.github.io/okhttp/
[24]: https://developer.android.com/guide/navigation/navigation-getting-started
[25]: https://developer.android.com/guide/navigation/navigation-pass-data
