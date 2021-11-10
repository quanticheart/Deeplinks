# Android Deeplinks Dispatcher 🤖
[medium](https://medium.com/@markchristopherng/why-im-feeling-it-big-for-deeplinkdispatch-2400bf0d9c7b) * Recommended
[Github](https://github.com/airbnb/DeepLinkDispatch)
[Medium](https://github.com/airbnb/DeepLinkDispatch)
[AndroidHiro](http://www.androidhiro.com/source/android/example/deeplinkdispatch/1709)

# Android Deeplinks Validation in Domain 🤖
##### Documentation
[verify-site-associations](https://developer.android.com/training/app-links/verify-site-associations)
[Android App Linking](https://simonmarquis.github.io/Android-App-Linking/)
[Handling specific routes in Android M app links](https://stackoverflow.com/questions/35840262/handling-specific-routes-in-android-m-app-links)

##### Generate your [assetlinks.json](.well-known/assetlinks.json):
[Statement List Generator and Tester](https://developers.google.com/digital-asset-links/tools/generator)

##### For verify your [assetlinks.json](.well-known/assetlinks.json):
```sh
https://digitalassetlinks.googleapis.com/v1/statements:list?source.web.site=https://www.yourdomainhere.com.br&relation=delegate_permission/common.handle_all_urls
```
or
[Appsflyer](https://www.appsflyer.com/tools/link-validator/)


##### for Example:
[Google](https://digitalassetlinks.googleapis.com/v1/statements:list?source.web.site=https://www.google.com&relation=delegate_permission/common.handle_all_urls)
[Facebook](https://digitalassetlinks.googleapis.com/v1/statements:list?source.web.site=https://www.facebook.com&relation=delegate_permission/common.handle_all_urls)

##### Call intent in Android Studio with ADB:
```sh
adb shell am start -a android.intent.action.VIEW \
    -c android.intent.category.BROWSABLE \
    -d "http://domain.name:optional_port"
```

##### Tip:
During app install/update, an Android service will verify if the App Links configuration complies with the server side assetlinks.json file.
The results will be sent to logcat, with these tags: IntentFilterIntentSvc and SingleHostAsyncVerifier
