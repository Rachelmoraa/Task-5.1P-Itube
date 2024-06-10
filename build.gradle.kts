plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.itube"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.itube"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation ("com.google.apis:google-api-services-youtube:v3-rev222-1.25.0")
    implementation ("com.pierfrancescosoffritti.androidyoutubeplayer:core:10.0.5")


}
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    //noinspection GradleCompatible
    //implementation("com.android.support:appcompat-v7:25.0.1")
    implementation("com.google.android.gms:play-services-auth:21.2.0")
    implementation("pub.devrel:easypermissions:0.3.0")
    implementation("com.google.api-client:google-api-client-android:1.22.0") {
        exclude(group = "org.apache.httpcomponents")
    }
    implementation("com.google.apis:google-api-services-youtube:v3-rev183-1.22.0") {
        exclude(group = "org.apache.httpcomponents")
    }
}