# 영화예매이

Development Infomation.

<li>java 8
<li>jsp 2.3
<li>mybatis 3.2
<li>Spring 3.8.1
<li>Apache Tomcat 8.0
<li>Oracle R11.2

## Contents


### Title

![logo]
(https://github.com/hhk2745/SpringProject_Movie-Ticketing-Site/tree/master/WebContent/img/logo.jpg)
CH OGV Web Application, first spring project.

![Cube](https://raw.githubusercontent.com/wiki/kakajika/FragmentAnimations/images/cube.gif)

### Flip Animation

[FlipAnimation.java](https://github.com/kakajika/FragmentAnimations/blob/master/fragmentanimations/src/main/java/com/labo/kaji/fragmentanimations/FlipAnimation.java)

![Flip](https://raw.githubusercontent.com/wiki/kakajika/FragmentAnimations/images/flip.gif)

### Push/Pull Animation

[PushPullAnimation.java](https://github.com/kakajika/FragmentAnimations/blob/master/fragmentanimations/src/main/java/com/labo/kaji/fragmentanimations/PushPullAnimation.java)

![Push/Pull](https://raw.githubusercontent.com/wiki/kakajika/FragmentAnimations/images/pushpull.gif)

### Sides Animation

[SidesAnimation.java](https://github.com/kakajika/FragmentAnimations/blob/master/fragmentanimations/src/main/java/com/labo/kaji/fragmentanimations/SidesAnimation.java)

### Move Animation

[MoveAnimation.java](https://github.com/kakajika/FragmentAnimations/blob/master/fragmentanimations/src/main/java/com/labo/kaji/fragmentanimations/MoveAnimation.java)

![Move](https://raw.githubusercontent.com/wiki/kakajika/FragmentAnimations/images/move.gif)

## Combination

You can use above Animations with another one.

```java
@Override
public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
    if (enter) {
        return MoveAnimation.create(MoveAnimation.UP, enter, DURATION);
    } else {
        return CubeAnimation.create(CubeAnimation.UP, enter, DURATION);
    }
}
```

### Cube/Move Animation

![Cube/Move](https://raw.githubusercontent.com/wiki/kakajika/FragmentAnimations/images/cubemove.gif)

### Move/Cube Animation

![Move/Cube](https://raw.githubusercontent.com/wiki/kakajika/FragmentAnimations/images/movecube.gif)

### Push/Move Animation

![Push/Move](https://raw.githubusercontent.com/wiki/kakajika/FragmentAnimations/images/pushmove.gif)

### Move/Pull Animation

![Move/Pull](https://raw.githubusercontent.com/wiki/kakajika/FragmentAnimations/images/movepull.gif)

## Install

This library is available in jcenter.

```groovy
dependencies {
    compile 'com.labo.kaji:fragmentanimations:0.1.1'
}
```

## License

    Copyright 2015 kakajika

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
