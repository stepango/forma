androidLibrary(
    packageName = "com.stepango.blockme.library.mvvm",

    dependencies = deps(
        google.material,
        androidx.core_ktx,
        androidx.appcompat,
        androidx.constraintlayout,
        androidx.databinding,
        androidx.navigation_fragment_ktx,
        androidx.navigation_ui_ktx,
        androidx.lifecycle_viewmodel,
        androidx.lifecycle_viewmodel_ktx,
        javax.inject
    ),

    testDependencies = deps(
        test.junit
    )
)