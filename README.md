# ToggleIconView

ToggleIconView is a collection library of animated two-stage toggle icons for Android.

https://user-images.githubusercontent.com/6717356/178526403-60881b61-90af-4e23-b731-1f349a3e9512.mp4

## Installation

// TODO :)

## Usage

``` xml
<!-- See "Built-in icons" section for other icons -->
<og.android.lib.toggleiconview.rounded.PlayPause
    android:layout_width="24dp"
    android:layout_height="24dp" />
```

## API

ToggleIconView, uses `AnimatedVectorDrawableCompat` under the hood and extends `AppCompatImageView`. So you can use
anything you can with `AppCompatImageView`.

### Attributes

| Attribute     | Description                        | Type      |
|---------------|------------------------------------|-----------|
| `app:checked` | Sets the initial state of the icon | `boolean` |

### Methods

| Method                         | Description                                                 | Return    |
|--------------------------------|-------------------------------------------------------------|-----------|
| `toggle()`                     | Toggles between the checked and unchecked state of the icon | `void`    |
| `isChecked()`                  | Returns whether the icon is checked                         | `boolean` |
| `setChecked(checked: Boolean)` | Sets the checked state of the icon                          | `void`    |

### Events

| Event                                                                  | Description                                        |
|------------------------------------------------------------------------|----------------------------------------------------|
| `onCheckedChanged(toggleIconView: ToggleIconView, isChecked: Boolean)` | Triggers when the ticked state of the icon changed |

## Built-in icons
| Preview                                                                                                   | Package                                                                      |
|-----------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------|
| ![](https://user-images.githubusercontent.com/6717356/178586997-ec1f822d-0355-468c-8ea4-6122dd24a22b.gif) | [Rounded] PlayPause<br />`og.android.lib.toggleiconview.rounded.PlayPause`   |
| ![](https://user-images.githubusercontent.com/6717356/178587007-a40486e7-11e3-43f1-bcb2-78a5afcedd05.gif) | [Rounded] SoundOnOff<br />`og.android.lib.toggleiconview.rounded.SoundOnOff` |
| ![](https://user-images.githubusercontent.com/6717356/178586969-c1270e15-76b7-4c68-83b7-c1f958aa5fb6.gif) | [Sharp] FlashOnOff<br />`og.android.lib.toggleiconview.sharp.FlashOnOff`     |

## TODO

- [ ] Improve the docs (with screenshots, code examples, etc.)
- [ ] Add new built-in icons (Start with https://github.com/ozgurg/ShapeShifter-Collection)
- [ ] Write how to create their own icons
- [ ] Make it extensible (with docs)
- [ ] Make it more robust (with tests)
- [ ] Publish it somewhere

## License

[![License](https://img.shields.io/github/license/ozgurg/toggle-icon-view)](https://github.com/ozgurg/toggle-icon-view/blob/main/LICENSE)
