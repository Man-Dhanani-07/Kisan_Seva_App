plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.man.fapp"
    compileSdk = 34
    buildFeatures {
        viewBinding = true;
    }

    defaultConfig {
        applicationId = "com.man.fapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.7.3"))


    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics")
    // fire store
    implementation("com.google.firebase:firebase-firestore")
    implementation ("com.google.firebase:firebase-auth:22.3.1")

    // storage
    implementation("com.google.firebase:firebase-storage")
    // glide
    implementation("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.14.2")

    implementation(platform("com.google.firebase:firebase-bom:32.7.4"))

    // Add the dependency for the Firebase Authentication library
    // When using the BoM, you don't specify versions in Firebase library dependencies

    implementation ("androidx.browser:browser:1.3.0")

    implementation("com.android.volley:volley:1.2.1")



//    implementation ("com.google.firebase:firebase-auth-api:21.0.0")

}