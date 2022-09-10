[![JitPack](https://img.shields.io/jitpack/v/github/ozgurg/ToggleIconView)](https://jitpack.io/#ozgurg/ToggleIconView)

# ToggleIconView

ToggleIconView is a collection library of animated two-stage toggle icons for Android.

![](https://raw.githubusercontent.com/ozgurg/ToggleIconView/master/.github/sample.gif)

## Installation

### JitPack repository

```gradle
// Project level build.gradle
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

If the above doesn't work for you, try the following:

```gradle
// settings.gradle
...
dependencyResolutionManagement {
    ...
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
...
```

### Implementation
```gradle
// App level build.gradle
dependencies {
    implementation "com.github.ozgurg:ToggleIconView:3.0.1"
}
```

## Usage

``` xml
<!-- See "Built-in icons" section for other icons -->
<og.android.lib.toggleiconview.rounded.PlayPause
    android:layout_width="24dp"
    android:layout_height="24dp" />
```

## API

ToggleIconView, uses `AnimatedVectorDrawableCompat` under the hood and extends `AppCompatImageView`. So you can do
anything you can with `AppCompatImageView` like tinting and other stuff. That's why I called it "collection library".

### Attributes

| Attribute                         | Description                                                | Type      | Default |
|-----------------------------------|------------------------------------------------------------|-----------|---------|
| `app:checked`                     | Sets the initial state of the icon                         | `Boolean` | `false` |
| `app:checkedContentDescription`   | Sets the initial checked content description of the icon   | `String`  | `null`  |
| `app:uncheckedContentDescription` | Sets the initial unchecked content description of the icon | `String`  | `null`  |
| `app:checkedTooltipText`          | Sets the initial checked tooltip text of the icon          | `String`  | `null`  |
| `app:uncheckedTooltipText`        | Sets the initial unchecked tooltip text of the icon        | `String`  | `null`  |

### Methods

| Method                                                                                           | Description                                                 | Return    |
|--------------------------------------------------------------------------------------------------|-------------------------------------------------------------|-----------|
| `toggle()`                                                                                       | Toggles between the checked and unchecked state of the icon | -         |
| `.isChecked` <br /> `isChecked()`                                                                | Returns the checked state of the icon                       | `Boolean` |
| `.isChecked = Boolean` <br /> `setChecked(isChecked: Boolean)`                                   | Sets the checked state of the icon                          | -         |
| `.checkedContentDescription` <br /> `getCheckedContentDescription()`                             | Returns the checked content description of the icon         | `String?` |
| `.checkedContentDescription = String?` <br /> `setCheckedContentDescription(value: String?)`     | Sets the checked content description of the icon            | -         |
| `.uncheckedContentDescription` <br /> `getUncheckedContentDescription()`                         | Returns the unchecked content description of the icon       | `String?` |
| `.uncheckedContentDescription = String?` <br /> `setUncheckedContentDescription(value: String?)` | Sets the unchecked content description of the icon          | -         |
| `.checkedTooltipText` <br /> `getCheckedTooltipText()`                                           | Returns the checked tooltip text of the icon                | `String?` |
| `.checkedTooltipText = String?` <br /> `setCheckedTooltipText(value: String?)`                   | Sets the checked tooltip text of the icon                   | -         |
| `.uncheckedTooltipText` <br /> `getUncheckedTooltipText()`                                       | Returns the unchecked tooltip text of the icon              | `String?` |
| `.uncheckedTooltipText = String?` <br /> `setUncheckedTooltipText(value: String?)`               | Sets the unchecked tooltip text of the icon                 | -         |

### Events

| Event                                                        | Description                                         |
|--------------------------------------------------------------|-----------------------------------------------------|
| `onCheckedChanged(view: ToggleIconView, isChecked: Boolean)` | Triggers when the checked state of the icon changed |

## Built-in icons

_All icons have the same duration (`@android:integer/config_shortAnimTime`) and interpolator (`@android:interpolator/fast_out_slow_in`), but I manually capture their previews; so timings may look different._

| Preview                                                                                                         | Package                                                                                |
|-----------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| ![](https://raw.githubusercontent.com/ozgurg/ToggleIconView/master/.github/preview/rounded/PlayPause.gif)       | [Rounded] PlayPause<br />`og.android.lib.toggleiconview.rounded.PlayPause`             |
| ![](https://raw.githubusercontent.com/ozgurg/ToggleIconView/master/.github/preview/sharp/PlayPause.gif)         | [Sharp] PlayPause<br />`og.android.lib.toggleiconview.sharp.PlayPause`                 |
| ![](https://raw.githubusercontent.com/ozgurg/ToggleIconView/master/.github/preview/rounded/SoundOnOff.gif)      | [Rounded] SoundOnOff<br />`og.android.lib.toggleiconview.rounded.SoundOnOff`           |
| ![](https://raw.githubusercontent.com/ozgurg/ToggleIconView/master/.github/preview/sharp/SoundOnOff.gif)        | [Sharp] SoundOnOff<br />`og.android.lib.toggleiconview.sharp.SoundOnOff`               |
| ![](https://raw.githubusercontent.com/ozgurg/ToggleIconView/master/.github/preview/sharp/FlashOnOff.gif)        | [Sharp] FlashOnOff<br />`og.android.lib.toggleiconview.sharp.FlashOnOff`               |
| ![](https://raw.githubusercontent.com/ozgurg/ToggleIconView/master/.github/preview/sharp/AirplaneModeOnOff.gif) | [Sharp] AirplaneModeOnOff<br />`og.android.lib.toggleiconview.sharp.AirplaneModeOnOff` |

## How do you create your custom icon?

### 1) Create an icon

First, you need to create an `AnimatedVectorDrawable` icon. I highly recommend using [Shape Shifter](https://shapeshifter.design/).

After creating and exporting your icon, add the icon to your project's `drawable` folder.

### 2) Implement the icon

Extend `ToggleIconView` class and set checked and unchecked icon you created.

``` kotlin
package [PACKAGE_NAME]

import android.content.Context
import android.util.AttributeSet
import og.android.lib.toggleiconview.R
import og.android.lib.toggleiconview.ToggleIconView

class [NAME_YOUR_ICON] @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    ToggleIconView(
        context, attrs, defStyleAttr,
        R.drawable.[CHECKED_ICON],
        R.drawable.[UNCHECKED_ICON]
    )
```

Then, use it in your layout.

``` xml
<[PACKAGE_NAME].[NAME_YOUR_ICON]
    android:layout_width="24dp"
    android:layout_height="24dp" />
```

## License

[![License](https://img.shields.io/github/license/ozgurg/ToggleIconView)](https://github.com/ozgurg/ToggleIconView/blob/main/LICENSE)
