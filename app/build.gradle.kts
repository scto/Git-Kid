import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin)
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
    //alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.aboutlibraries)
}

android {
    namespace = "com.redeyesncode.gitkid"

    defaultConfig {
        applicationId = "com.redeyesncode.gitkid"

        vectorDrawables.useSupportLibrary = true
        
        /*
        val githubToken = getSecretProperty("VCSPACE_TOKEN")
        val clientId = getSecretProperty("CLIENT_ID")
        val clientSecret = getSecretProperty("CLIENT_SECRET")
        val callbackUrl = getSecretProperty("OAUTH_REDIRECT_URL")

        buildConfigField("String", "GITHUB_TOKEN", "\"$githubToken\"")
        buildConfigField("String", "CLIENT_ID", "\"$clientId\"")
        buildConfigField("String", "CLIENT_SECRET", "\"$clientSecret\"")
        buildConfigField("String", "OAUTH_REDIRECT_URL", "\"$callbackUrl\"")
        */
    }

    signingConfigs {
        create("general") {
            storeFile = file("test.keystore")
            keyAlias = "test"
            keyPassword = "test0x"
            storePassword = "test0x"
        }
    }

    buildTypes {
        release {
            isDebuggable = false
            isMinifyEnabled = true
            isCrunchPngs = false
            isShrinkResources = false // disabled to fix F-Droid's reproducible build
            signingConfig = signingConfigs.getByName("general")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        
        debug {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
            isDebuggable = true
            isMinifyEnabled = false
            isCrunchPngs = false
            isShrinkResources = false // disabled to fix F-Droid's reproducible build
            signingConfig = signingConfigs.getByName("general")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions { isCoreLibraryDesugaringEnabled = true }

    packaging {
        resources.excludes.addAll(
            arrayOf(
                "META-INF/README.md",
                "META-INF/CHANGES",
                "bundle.properties",
                "plugin.properties"
            )
        )

        jniLibs { useLegacyPackaging = true }
    }

    lint {
        abortOnError = false
        disable += listOf("MaterialDesignInsteadOrbitDesign")
    }

    buildFeatures {
        viewBinding = true
        //buildConfig = true
        //compose = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraint.layout)
    implementation(libs.material)
    
    implementation(libs.android.spd)
    
    coreLibraryDesugaring(libs.androidx.desugar)

    //testImplementation(libs.junit)
    
    //androidTestImplementation(libs.androidx.junit)
    //androidTestImplementation(libs.androidx.espresso.core)
    
    /*
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.viewbinding)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.datastore.prefs)

    implementation(libs.compose.preference.library)

    // Compose Material Design extended icons. This module contains all Material icons.
    // It is a very large dependency (almost 36MB)
    implementation(libs.androidx.material.icons.extended)

    implementation(libs.konfetti.compose)

    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    coreLibraryDesugaring(libs.androidx.desugar)

    implementation(libs.androidx.annotation)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.preference)
    implementation(libs.androidx.webkit)

    implementation(libs.google.material)
    implementation(libs.google.guava)
    implementation(libs.google.gson)
    implementation(libs.google.accompanist.permissions)
    implementation(libs.google.accompanist.systemuicontroller)
    implementation(libs.google.generativeai)

    implementation(libs.common.editor)
    implementation(libs.common.editor.lsp)
    implementation(libs.common.editor.textmate)
    implementation(libs.common.editor.treesitter)
    implementation(libs.common.utilcode)
    implementation(libs.common.eventbus)
    implementation(libs.common.p7zip)
    implementation(libs.common.terminal.view)
    implementation(libs.common.terminal.emulator)

    implementation(libs.androidx.nav.fragment)
    implementation(libs.androidx.nav.ui)
    implementation(libs.androidx.nav.dynamic.features)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.browser)

    implementation(libs.retrofit)

    implementation(project(":core:common"))
    implementation(project(":core:resources"))
    implementation(project(":feature:editor"))
    implementation(project(":feature:monaco-editor"))
    implementation(project(":feature:preferences"))
    implementation(project(":feature:plugins"))

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.android.tree.sitter)
    implementation(libs.tree.sitter.java)

    implementation(libs.bsh)
    implementation(libs.org.eclipse.jgit)
    implementation(libs.org.eclipse.lsp4j)
    implementation(libs.org.eclipse.lsp4j.jsonrpc)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.okhttp)

    implementation(libs.nanohttpd)
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)
    implementation(libs.compose.markdown)
    implementation(libs.androidsvg)
    implementation(libs.aboutlibraries.core)
    implementation(libs.aboutlibraries.compose.m3)

    implementation(libs.orbit.ui)
    implementation(libs.orbit.icons)

    debugImplementation(libs.common.leakcanary)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    */
}

private fun getSecretProperty(name: String): String {
    val file = project.rootProject.file("token.properties")

    return if (file.exists()) {
        val properties = Properties().also { it.load(file.inputStream()) }
        properties.getProperty(name) ?: ""
    } else ""
}