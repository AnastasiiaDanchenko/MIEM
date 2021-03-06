# Приложение-квест "Путешествие по МИЭМ" на мобильной платформе
## Общее описание
Объектом разработки в данном проекте стало приложение под мобильную платформу Android. Для разработки использовался язык программирования Java.

Игра построена в жанре "побег": игроку необходимо искать подсказки, решать головоломки и задачи на различные темы, чтобы продвинуться 
дальше. По ходу игры пользователь получает различную информацию о МИЭМ: о его департаментах, научных лабораториях, 
студенческих организациях факультета.

Помимо этого, игрок узнает о МИЭМ непосредственно изнутри здания: игровой процесс построен таким образом, что человек оказывается внутри 
стен факультета и исследует оба корпуса здания, получая тем самым возможность познакомиться с ним поближе.

## Запуск приложения
Приложение поддерживает все версии Android, начиная с 4.4 (KitKat). Для установки приложения на устройство необходимо скачать файл 
app-debug.apk из папки MIEM (MIEM/app-debug.apk -> Download), потом открыть файл на устройстве и подтвердить установку. После этого на 
главном экране смартфона появится иконка с названием игры:

![Иконка приложения](https://github.com/AnastasiiaDanchenko/MIEM/blob/master/screen1.jpg)

После нажатия на иконку запустится приложение и откроется главное окно:

![Главное окно приложения](https://github.com/AnastasiiaDanchenko/MIEM/blob/master/main.jpg)

По умолчанию в приложении включается фоновая музыка, отключить её можно, перейдя в "Настройки" и нажав кнопку "Выкл" (соответственно 
"Вкл", чтобы включить музыку). Здесь же можно сбросить прогресс игры, нажав "Сбросить" и подтвердив свой выбор.

![Настройки](https://github.com/AnastasiiaDanchenko/MIEM/blob/master/settings.jpg)

При нажатии кнопки "Начать" открывается окно с выбором уровня. Изначально доступен лишь один уровень, при продвижении по игре постепенно
открываются новые.

![Уровни](https://github.com/AnastasiiaDanchenko/MIEM/blob/master/levels.jpg)

После выбора одного из доступных уровней открывается соответствующее окно (на скриншоте окно уровня 1):

![Комната](https://github.com/AnastasiiaDanchenko/MIEM/blob/master/room.jpg)

Игрок может перемещаться по комнате/этажу/аудитории в рамках одного уровня, после решения всех задач и получения всей доступной информации 
на данном уровне он получает возможность двигаться дальше.

## Пояснения к репозиторию
1. Манифест приложения: https://github.com/AnastasiiaDanchenko/MIEM/blob/master/app/src/main/AndroidManifest.xml
2. Папка с Java-файлами (окна-activity приложения): https://github.com/AnastasiiaDanchenko/MIEM/tree/master/app/src/main/java/com/example/miem
3. Используемые изображения: https://github.com/AnastasiiaDanchenko/MIEM/tree/master/app/src/main/res/drawable
4. Используемые аудиофайлы: https://github.com/AnastasiiaDanchenko/MIEM/tree/master/app/src/main/res/raw
5. XML-файлы для всех activity: https://github.com/AnastasiiaDanchenko/MIEM/tree/master/app/src/main/res/layout
6. Анимация для переключения между activity: https://github.com/AnastasiiaDanchenko/MIEM/tree/master/app/src/main/res/anim
7. Файлы шрифтов: https://github.com/AnastasiiaDanchenko/MIEM/tree/master/app/src/main/res/font
8. Текст, используемый в приложении: https://github.com/AnastasiiaDanchenko/MIEM/tree/master/app/src/main/res/values
9. Стиль для кнопок: https://github.com/AnastasiiaDanchenko/MIEM/blob/master/app/src/main/res/drawable/gradient.xml
10. Исполняемый файл приложения: https://github.com/AnastasiiaDanchenko/MIEM/blob/master/app-debug.apk

## Ссылки и используемая литература:
1. https://www.udemy.com/course/become-an-android-developer-from-scratch/
2. https://miem.hse.ru/
3. https://developer.android.com/docs/quality-guidelines/core-app-quality
