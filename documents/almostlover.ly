\version "2.18.2"

\include "english.ly"

amlostLoverTitle = "ALMOST LOVER"

vocalLyricsA = \lyricmode {
  %1-8
  Your fin -- ger
  tips a -- cross my skin, the palm trees
  sway -- ing in the wind im -- ag -- es __
  You sang _ me


}

vocalLyricsB = \lyricmode {
  %1-8
  _ _ _
  Span -- ish lul -- la -- bies,
  the sweet -- est sad -- ness in your eyes,
  clev -- er trick. _ Well, I __ _
  %9 - 12 sengo fragment 1
  nev -- er want __ to see __ you __ un -- hap -- py __
  I thought you'd want the same for me __
  Good -- bye __ my al -- most lov -- er,
  %13 - 16 sengo fragment 2
  good -- bye __ my hope -- less dream, __
  I'm try -- ing not to think a -- bout __ you
  can't __ you just let me be? __
  %16 - 21 sengo fragment 3
  So long __ my luck -- less ro -- mance,
  my back __ is turned on you, __
  shoud've I known you'd bring me heart -- ache
  al -- most lov -- ers al -- ways do. __
  %22 - 24 sengo fragment 4
  We walked a -- long a crowed -- ed street, __
  you took my hand and danced with me.
  In the shadow. __
  %24 - 28
  And when you left you kissed my lips,
  you told me you would ne -- ver,
  e -- ver for -- get these im -- ag -- es, __
  no... __
  %29 -34
  Well, I'd %jumpt to the sengo

}

vocalLyricsC = \lyricmode {

  do. __ % coda point
  I can -- not go to the o -- cean,
  I can -- not drive the streets __ at night,
  I can -- not wake up in the morn - ing
  without you on my mind,
  %35 - 38
  So you're gone and I'm haut -- ed
  and I beg you are just __ fine.
  Did I make it that __ eas -- y
  to walk right in and out of my life? __
  %39 -
  Good -- bye __ my al -- most lov -- er,
  good -- bye __ my hope -- less dream, __
  I'm try -- ing not to think a -- bout you,
  can't you just let me be? __
  So long __ my luck -- less ro --mance,
  my back __ is turned on you, __
  shoud've I known __ you bring me heart -- ache,
  al -- most lov -- ers al -- ways do. __

}

mainVocalMelody = {
  \relative c' {
    %1 - 4 predule
    \tempo "Moderately Slow"
    \time 4/4
    r1 |
    r |
    r |
    r2 r8 e d c|

    %5-8 repeat main part
    \repeat volta 2 {
      a8 e' d c a8. e'16 d8 c |
      d8 c d a16 c~ c4 e16 d8 c16~ |
      c4 r r2 |
      r2 r8 e d16 c c8 |
    }
    \inStaffSegno
    %9 - 12
    d8 c16 d~ d c d8~ d g~ g e |
    e16 e8. ( e4 ) r c |
    d16 c d c d4 r a8 g~ |
    g4 r4 r2 |
    %13 - 16
    r8 e'16 e ( e d ) c8 c g a16 c8. |
    r8 e16 d ( d8 ) d g e d16 ( c8. ) |
    r8 e e16 d c a c8 d16 c ( c8 ) a |
    r8 c ( c ) d16 c c8 d e16 ( d c8 ) |
    %17 - 21
    r8 e16 e~ ( e d ) c8 c g a16 c8. |
    r8 e16 d~ d8. d16 g8 e d16 ( c8. )  |
    r8 d16~ d e d c8 c d c a  |
    r8 c8~ c d c16 d8. c8 d |
    r8 e16 ( d c4 ) r2 |
    %22 - 24
    r2 r8 e d c |
    a8 e' d c16 a~ a8. e'16 d8 c |
    d8 d16 e ( d ) c c8 r4 e8. d16 |
    %25 - 28
    e8 ( d16 c d8 c16 b c b8.~ b16 a  b c~ |
    c4 ) r r8 r16 e16 d8 c |
    a8 e' d c a8. g'16 g16 g g e |
    %29 - 32
    a8 g16 g~ g8 e16 a g8 e e16 g8.~ |
    g8 e16 ( d e4 ) r c'16 ( b a b |
    a16 g8. ) r4 r r16 c,16 c8 ^ \markup { \italic D.S al Coda  } |

  }
}


subVocalMelody = {
  \relative c' {
    %1 - 4 predule
    %\tempo "Moderately Slow"
    \time 4/4
    r8 ^ \markup { \italic \bold CODA }
    e16 ( d c4 ) r2 |
    %33 - 36
    r8 r16 e a8 a a g a a |
    g8. e16 g8 g g e16 e~ e e8. |
    a8. a16 a8 a a g a16 g a8 |
    g4 g16 g8. g8 e e e |
    %37 - 41
    r4 a16 a8. a8 g a a |
    g8. e16 g16 g8. g8 g16 c~ c4 |
    c,4 r16 c16 e8 d c16 a~ a8 e' |
    d8. c16 d d8. d16 e d8 r8 a16 e' |
    g16 ( e8 f32 e32 d16 e8. ) r2 |
    %42 - end
    r8 e16 e ( e d ) c8 c g a16 c8. |
    r8 e16 d ( d8 ) d g e d16 ( c8. ) |
    r8 e e16 d c a c8 d16 c ( c8 ) a |
    r8 c ( c ) d16 c c8 g' a16 ( g8. ) |
    %17 - 21
    r8 e16 e~ ( e d ) c8 c g a16 c8. |
    r8 e16 d~ d8. d16 g8 e d16 ( c8. )  |
    r8 d16~ d e d c8 c d c a  |
    r8 c4 d8 c16 d8. c8 d |
    e8. ( d32 c d16 c8.~ c4 ) r4 |
  }
}


mainVocalData = <<

  \new Voice = "mainMelody" {
    \mainVocalMelody
  }

  <<
    \new Lyrics \lyricsto "mainMelody" {
      \vocalLyricsA
    }

    \new Lyrics \lyricsto "mainMelody" {
      \vocalLyricsB
    }

  >>
>>


subVocalData = <<

  \new Voice = "subMelody" {
    \subVocalMelody
  }

  \new Lyrics \lyricsto "subMelody" {
    \vocalLyricsC
  }

>>

mainTrebleStaffData = <<

  \new Voice = "upStair" {
    \voiceOne
    \relative c' {
      %1 - 4 predule
      <c' e>2. <c e>4 |
      <a c	>1 |
      <c e>1 |
      <f, a c>1|
      %5-8 repeat main part
      s1 |
      <f a c>4 <f a c> <f a c> <f a c> |
      e8 a <c e> a e a <c e> a |
      a1 |
      %9 - 12 sengo fragment 1
      <d, g b>4 <d g b> <d g b> <d g b> |
      <c e g>4 <c e g> <c e g> <c e g> |
      <a d f>4 <a d f> <a d f> <a d f> |
      \autoBeamOff
      r8 g ~ g  [ d' ] <g, b>2 |
      \autoBeamOn
      %12-16
      <c e g>4 <c e g> <c e g> <c e g> |
      <b d g>4 <b d g> <b d g> <b d g> |
      <a d f>4 <a d f> <a d f> <a d f> |
      <a c f>4 <a c f> <a c f> <a c f> |
      %16 - 21
      <c e g>4 <c e g> <c e g> <c e g> |
      <b d g>4 <b d g> <b d g> <b d g> |
      <a d f>4 <a d f> <a d f> <a d f> |
      <a c f>4 <a c f> <a c f> <a c f> |
      <c e g>4 <c e g> <c e g> <c e g> |
      %22 - 25
      <e g>8 c~ c c~ c2 |
      <a' c e>4 <a c e> <a c e> <a c e> |
      <f a c>4 <f a c> <f a c> <f a c> |
      <a c e>4 <a c e> <a c e> <a c e> |
      %26 - 31
      <f a c>4 <f a c> <f a c> <f a c> |
      <a c e>4 <a c e> <a c e> <a c e> |
      <f a c>4 <f a c> <f a c> <f a c> |
      <a c e>4 <a c e> <a c e> <a c e> |
      <f a c>4 <f a c> <f a c> <f a c> |
    }
  }

  \new Voice = "downStair" {
    \voiceTwo
    \relative c' {
      %1 - 4 predule
      e8 a e a e a e a |
      e8 a e a e a e a |
      e8 a e a e a e a |
      c,1 |
      %5-8 repeat main part
      <a' c e>4 <a c e> <a c e> <a c e> |
      s1|
      s1 |
      c,8 f c f c2 |
      %9 - 12 sengo fragment 1
      s1 | s1 | s1 | s1 |
      %12- 16
      s1 | s1 | s1 | s1 |
      %16 - 20
      s1 | s1 | s1 | s1 |
      %21 - 24
      s1 | s1 | s1 | s1 |
      %25 - 28
      s1 | s1 | s1 | s1 |
      %29 - 31
      s1 | s1 |

    }
  }
>>

mainBassStaffData =  \relative c' {
  %1 - 4 predule
  a1 | f1 |a1 | f1 |
  %5-8 repeat main part
  a1 | f1 |a1 | f1 |
  %9 - 12 sengo fragment 1
  g1 | c,1 | d1 | g,1 |
  %13 - 16
  c1 | g1 | d'1 | f1 |
  %17 - 21
  c1 | g1 | d'1 | f1 | c1 |
  %22 - 25
  c1 | a1 | f1 | a1 |
  %26 - 29
  f1 | a1 | f1 | a1 |
  %30
  f1 |
}

subTrebleStaffData = {

  \new Voice = "subUpstair" {

    \relative c' {
      %1 -4
      < c e g >4 < c e g > < c e g > < c e g >8 < b d f > |
      < a c e >4 < a c e > < a c e > < a c e > |
      < g b d>4 < g b d > < g b d > < g b d > |
      < f a c >4 < f a c > < f a c > < f a c > |
      %5 -8
      < e g b >4 < e g b > < e g b > < e g b > |
      < f a c >4 < f a c > < f a c > < f a c > |
      < g b d>4 < g b d > < g b d >2 |
      < f a c >4 < f a c > < f a c > < f a c > |
      %9 - 12
      < d f a >4 < d f a > < d f a >2 |
      < g b d >1 |
      < g c e >1 |
      < g b d >1 |
      %13 - 16
      < a d f >1 |
      < a c f >1 |
      < c e g >4 < c e g > < c e g > < c e g > |
      < b d g >4 < b d g > < b d g > < b d g > |
      %17 - 19
      < a d f >4 < a d f > < a d f > < a d f > |
      < a c f >1 |
      < c e g >1 |
    }

  }

}

subBassStaffData = \relative c' {
  %1 - 4
  c,2. c8 b8 | a1 | g1 | f1 |
  %5 - 8
  e1 | a1| | g1 | f1 |
  %9 - 12
  d1 | g1 | c1 | g1 |
  %13 - 16
  d'1 | f1 | c1 | g'1 |
  %17 - 19
  d1 | f1 | c1 |

}


#(define my-instrument-equalizer-alist '())

#(set! my-instrument-equalizer-alist
  (append
    '(
      ("acoustic guitar (steel)" . (0.7 . 0.9))
      ("acoustic grand" . (0.5 . 0.7))
      ("violin" . (0.1 . 0.2)))
    my-instrument-equalizer-alist))

#(define (my-instrument-equalizer s)
  (let ((entry (assoc s my-instrument-equalizer-alist)))
    (if entry
      (cdr entry))))

\book {

  \markup \null
  \header {
    title = \amlostLoverTitle
    dedication = "To. Teresa Teng"
    %subtitle = "Subtitle"
    %subsubtitle = "Subsubtitle"
    % The following fields are evenly spread on one line
    % the field "instrument" also appears on following pages
    %instrument = \markup \with-color #green "Instrument"
    %poet = "Poet"
    composer = "Words and Music by \n A FINE FRENZY"
    % The following fields are placed at opposite ends of the same line
    %meter = "Meter"
    %arranger = "Arranger"
    % The following fields are centered at the bottom
    tagline = "The first opus made by lilypond by heavy james"
    copyright = ""
  }

  \score {
    <<

      \new Staff = "vocalMainStaff" {
        \set Staff.midiInstrument = #"acoustic grand"
        %\set Staff.midiInstrument = "acoustic grand"
        \set Score.instrumentEqualizer = #my-instrument-equalizer
        \mainVocalData

      }

      \new PianoStaff = "instrumentMainStaff" {

        <<
          \new Staff {
            \clef "treble"
            \set Staff.midiInstrument = "acoustic grand"
            %\set Staff.midiInstrument = #"acoustic guitar (steel)"
            \set Score.instrumentEqualizer = #my-instrument-equalizer
            \mainTrebleStaffData
          }

          \new Staff {
            \clef "bass"
            %\set Staff.midiInstrument = #"flute"
            \set Score.instrumentEqualizer = #my-instrument-equalizer
            \mainBassStaffData

          }
        >>

      }

    >>

    \midi {
      \tempo 4 = 60
      \context {

        \Staff
        \remove "Staff_performer"
      }

      \context {
        \Voice
        \remove "Dynamic_performer"
        \consists "Staff_performer"
      }

    }

    \layout {

    }

  }

  \score {
    <<

      \new Staff = "vocalSubStaff" {
        \set Staff.midiInstrument = #"acoustic grand"
        %\set Staff.midiInstrument = "acoustic grand"
        \set Score.instrumentEqualizer = #my-instrument-equalizer
        \subVocalData

      }

      \new PianoStaff = "instrumentSubStaff" {

        <<
          \new Staff {
            \clef "treble"
            \set Staff.midiInstrument = "acoustic grand"
            %\set Staff.midiInstrument = #"acoustic guitar (steel)"
            \set Score.instrumentEqualizer = #my-instrument-equalizer
            \subTrebleStaffData
          }

          \new Staff {
            \clef "bass"
            %\set Staff.midiInstrument = #"flute"
            \set Score.instrumentEqualizer = #my-instrument-equalizer
            \subBassStaffData

          }
        >>

      }

    >>

    \midi {
      \tempo 4 = 60
      \context {

        \Staff
        \remove "Staff_performer"
      }

      \context {
        \Voice
        \remove "Dynamic_performer"
        \consists "Staff_performer"
      }
    }

    \layout {

    }


  }


}