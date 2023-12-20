import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}
fun getApiKey(properties: String): String {
    return gradleLocalProperties(rootDir).getProperty(properties)
}
android {
    namespace = "com.coinsimulation"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.coinsimulation"
        minSdk = 33
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        buildConfigField("String", "KAKAO_NATIVE_APP_KEY", getApiKey("kakao_native_app_key"))
        resValue("string", "kakao_oauth", getApiKey("kakao_oauth"))
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        viewBinding = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val activity_version = "1.8.1"
    //카카오 로그인
    implementation("com.kakao.sdk:v2-all:2.18.0") // 전체 모듈 설치, 2.11.0 버전부터 지원
    implementation("com.kakao.sdk:v2-user:2.18.0") // 카카오 로그인
    implementation("com.kakao.sdk:v2-talk:2.18.0") // 친구, 메시지(카카오톡)
    implementation("com.kakao.sdk:v2-share:2.18.0")// 메시지(카카오톡 공유)
    implementation("com.kakao.sdk:v2-friend:2.18.0") // 카카오톡 소셜 피커, 리소스 번들 파일 포함
    implementation("com.kakao.sdk:v2-navi:2.18.0")// 카카오내비
    implementation("com.kakao.sdk:v2-cert:2.18.0")// 카카오 인증서비스
    //api 통신
    implementation("com.squareup.retrofit2:retrofit:2.5.0")
    implementation("com.squareup.retrofit2:converter-gson:2.6.0")
    //테이블 생성
    implementation("com.seanproctor:datatable:0.2.1")
    //화면 이동
    implementation("androidx.navigation:navigation-compose:2.7.5")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.5")
    // 폰트
    implementation("androidx.compose.ui:ui-text-google-fonts:1.5.4")
    // Java language implementation
    implementation("androidx.activity:activity-ktx:$activity_version")
    // Kotlin
    implementation("androidx.activity:activity-ktx:$activity_version")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}