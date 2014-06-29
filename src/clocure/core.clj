(ns clocure.core)

(defrecord Human
  [id
   name
   first-name      family-name
   first-name-kana family-name-kana
   first-name-en   family-name-en
   after-transforming])

(defmacro def-human
  [first-name-en   family-name-en
   first-name      family-name
   first-name-kana family-name-kana
   & after-transforming]
  `(intern *ns*
    '~first-name-en ; use as an ID
    (->Human
      '~first-name-en ; use as an ID
      (str '~family-name '~first-name)
      (str '~first-name)      (str '~family-name)
      (str '~first-name-kana) (str '~family-name-kana)
      (clojure.string/capitalize '~first-name-en)
      (clojure.string/capitalize '~family-name-en)
      '~after-transforming)))

(defrecord Precure
  [id
   name    short-name
   name-en short-name-en
   before])

(defmacro def-precure
  [short-name-en short-name before]
  `(intern *ns*
    '~short-name-en ; use as an ID
    (->Precure
      '~short-name-en ; use as an ID
      (str "キュア" '~short-name) (str '~short-name)
      (str "Cure " (clojure.string/capitalize '~short-name-en))
      (clojure.string/capitalize '~short-name-en)
      '~before)))

(def-human nagisa   misumi     なぎさ 美墨   なぎさ   みすみ         black       )
(def-human honoka   yukishiro  ほのか 雪城   ほのか   ゆきしろ       white       )
(def-human hikari   kujo       ひかり 九条   ひかり   くじょう       luminous    )
(def-human saki     hyuga      咲     日向   さき     ひゅうが       bloom bright)
(def-human mai      misho      舞     美翔   まい     みしょう       egret windy )
(def-human nozomi   yumehara   のぞみ 夢原   のぞみ   ゆめはら       dream       )
(def-human rin      natsuki    りん   夏木   りん     なつき         rouge       )
(def-human urara    kasugano   うらら 春日野 うらら   かすがの       lemonade    )
(def-human komachi  akimoto    こまち 秋元   こまち   あきもと       mint        )
(def-human karen    minazuki   かれん 水無月 かれん   みなづき       aqua        )
(def-human kurumi   mimino     くるみ 美々野 くるみ   みみの         rose        )
(def-human love     momozono   ラブ   桃園   らぶ     ももぞの       peach       )
(def-human miki     aono       美希   蒼乃   みき     あおの         berry       )
(def-human inori    yamabuki   祈里   山吹   いのり   やまぶき       pine        )
(def-human setsuna  higashi    せつな 東     せつな   ひがし         passion     )
(def-human tsubomi  hanasaki   つぼみ 花咲   つぼみ   はなさき       blossom     )
(def-human erika    kurumi     えりか 来海   えりか   くるみ         marine      )
(def-human itsuki   myodoin    いつき 明堂院 いつき   みょうどういん sunshine    )
(def-human yuri     tsukikage  ゆり   月影   ゆり     つきかげ       moonlight   )
(def-human hibiki   hojo       響     北条   ひびき   ほうじょう     melody      )
(def-human kanade   minamino   奏     南野   かなで   みなみの       rhythm      )
(def-human ellen    kurokawa   エレン 黒川   えれん   くろかわ       beat        )
(def-human ako      shirabe    アコ   調辺   あこ     しらべ         muse        )
(def-human miyuki   hoshizora  みゆき 星空   みゆき   ほしぞら       happy       )
(def-human akane    hino       あかね 日野   あかね   ひの           sunny       )
(def-human yayoi    kise       やよい 黄瀬   やよい   きせ           peace       )
(def-human nao      midorikawa なお   緑川   なお     みどりかわ     march       )
(def-human reika    aoki       れいか 青木   れいか   あおき         beauty      )
(def-human ayumi    sakagami   あゆみ 坂上   あゆみ   さかがみ       echo        )
(def-human mana     aida       マナ   相田   まな     あいだ         heart       )
(def-human rikka    hishikawa  六花   菱川   りっか   ひしかわ       diamond     )
(def-human arisu    yotsuba    ありす 四葉   ありす   よつば         rosetta     )
(def-human makoto   kenzaki    真琴   剣崎   まこと   けんざき       sword       )
(def-human aguri    madoka     亜久里 円     あぐり   まどか         ace         )
(def-human megumi   aino       めぐみ 愛乃   めぐみ   あいの         lovely      )
(def-human hime     shirayuki  ひめ   白雪   ひめ     しらゆき       princess    )
(def-human yuko     omori      ゆうこ 大森   ゆうこ   おおもり       honey       )
(def-human iona     hikawa     いおな 氷川   いおな   ひかわ         fortune     )

(def-precure black     ブラック     nagisa  )
(def-precure white     ホワイト     honoka  )
(def-precure bloom     ブルーム     saki    )
(def-precure egret     イーグレット mai     )
(def-precure bright    ブライト     saki    )
(def-precure windy     ウィンディ   mai     )
(def-precure dream     ドリーム     nozomi  )
(def-precure rouge     ルージュ     rin     )
(def-precure lemonade  レモネード   urara   )
(def-precure mint      ミント       komachi )
(def-precure aqua      アクア       karen   )
(def-precure peach     ピーチ       love    )
(def-precure berry     ベリー       miki    )
(def-precure pine      パイン       inori   )
(def-precure passion   パッション   setsuna )
(def-precure blossom   ブロッサム   tsubomi )
(def-precure marine    マリン       erika   )
(def-precure sunshine  サンシャイン itsuki  )
(def-precure moonlight ムーンライト yuri    )
(def-precure melody    メロディ     hibiki  )
(def-precure rhythm    リズム       kanade  )
(def-precure beat      ビート       ellen   )
(def-precure muse      ミューズ     ako     )
(def-precure happy     ハッピー     miyuki  )
(def-precure sunny     サニー       akane   )
(def-precure peace     ピース       yayoi   )
(def-precure march     マーチ       nao     )
(def-precure beauty    ビューティ   reika   )
(def-precure echo      エコー       ayumi   )
(def-precure heart     ハート       mana    )
(def-precure diamond   ダイヤモンド rikka   )
(def-precure rosetta   ロゼッタ     arisu   )
(def-precure sword     ソード       makoto  )
(def-precure ace       エース       aguri   )
(def-precure lovely    ラブリー     megumi  )
(def-precure princess  プリンセス   hime    )
(def-precure honey     ハニー       yuko    )
(def-precure fortune   フォーチュン iona    )
(def luminous {
  :id 'luminous
  :name "シャイニールミナス" :short-name "ルミナス"
  :name-en "Shiny Luminous"  :short-name-en "Luminous"
  :before 'hikari})
(def rose {
  :id 'rose
  :name "ミルキーローズ" :short-name "ローズ"
  :name-en "Milky Rose"  :short-name-en "Rose"
  :before 'kurumi})

(def transform-messages {
  :black "デュアル・オーロラ・ウェイブ！！\n光の使者、キュアブラック！\nふたりはプリキュア！\n闇の力のしもべ達よ！\nとっととお家に帰りなさい！"
  :white "デュアル・オーロラ・ウェイブ！！\n光の使者、キュアホワイト！\nふたりはプリキュア！\n闇の力のしもべ達よ！\nとっととお家に帰りなさい！"
  :luminous "ルミナス・シャイニングストリーム！\n輝く命、シャイニールミナス！\n光の心と光の意志、すべてを一つにするために！"
  :bloom "デュアル・スピリチュアル・パワー！\n花開け大地に！\n輝く金の花！ キュアブルーム！\nふたりはプリキュア！\n聖なる泉を汚す者よ！\n阿漕な真似はお止めなさい！"
  :egret "デュアル・スピリチュアル・パワー！\n羽ばたけ空に！\n煌めく銀の翼！ キュアイーグレット！\nふたりはプリキュア！\n聖なる泉を汚す者よ！\n阿漕な真似はお止めなさい！"
  :bright "デュアル・スピリチュアル・パワー！\n未来を照らし！\n天空に満ちる月！ キュアブライト！\nふたりはプリキュア！\n聖なる泉を汚す者よ！\n阿漕な真似はお止めなさい！"
  :windy "デュアル・スピリチュアル・パワー！\n勇気を運べ！\n大地に薫る風！ キュアウィンディ！\nふたりはプリキュア！\n聖なる泉を汚す者よ！\n阿漕な真似はお止めなさい！"
  :dream "プリキュア！メタモルフォーゼ！\n大いなる希望の力、キュアドリーム！\n希望の力と未来の光！\n華麗に羽ばたく5つの心！\nYes！プリキュア5！"
  :rouge "プリキュア！メタモルフォーゼ！\n情熱の赤い炎、キュアルージュ！\n希望の力と未来の光！\n華麗に羽ばたく5つの心！\nYes！プリキュア5！"
  :lemonade "プリキュア！メタモルフォーゼ！\nはじけるレモンの香り、キュアレモネード！\n希望の力と未来の光！\n華麗に羽ばたく5つの心！\nYes！プリキュア5！"
  :mint "プリキュア！メタモルフォーゼ！\n安らぎの緑の大地、キュアミント！\n希望の力と未来の光！\n華麗に羽ばたく5つの心！\nYes！プリキュア5！"
  :aqua "プリキュア！メタモルフォーゼ！\n知性の青き泉、キュアアクア！\n希望の力と未来の光！\n華麗に羽ばたく5つの心！\nYes！プリキュア5！"
  :rose "スカイローズ・トランスレイト！\n青いバラは秘密のしるし！ ミルキィローズ！"
  :peach "チェインジ！プリキュア・ビートアップ！\nピンクのハートは愛あるしるし！\nもぎたてフレッシュ、キュアピーチ！\nレッツプリキュア！"
  :berry "チェインジ！プリキュア・ビートアップ！\nブルーのハートは希望のしるし！\nつみたてフレッシュ、キュアベリー！\nレッツプリキュア！"
  :pine "チェインジ！プリキュア・ビートアップ！\nイエローハートは祈りのしるし！\nとれたてフレッシュ、キュアパイン！\nレッツプリキュア！"
  :passion "チェインジ！プリキュア・ビートアップ！\n真っ赤なハートは幸せの証！\n熟れたてフレッシュ、キュアパッション！\nレッツプリキュア！"
  :blossom "(プリキュアの種、いくですぅ！)\nプリキュア！オープンマイハート！\n大地に咲く一輪の花！ キュアブロッサム！\nハートキャッチ、プリキュア！"
  :marine "(プリキュアの種、いくですぅ！)\nプリキュア！オープンマイハート！\n海風に揺れる一輪の花！ キュアマリン！\nハートキャッチ、プリキュア！"
  :sunshine "(プリキュアの種、いくですぅ！)\nプリキュア！オープンマイハート！\n陽の光浴びる一輪の花！ キュアサンシャイン！\nハートキャッチ、プリキュア！"
  :moonlight "(プリキュアの種、いくですぅ！)\nプリキュア！オープンマイハート！\n月光に冴える一輪の花 キュアムーンライト！\nハートキャッチ、プリキュア！"
  :melody "レッツプレイ！プリキュアモジュレーション！！\n爪弾くは荒ぶる調べ！ キュアメロディ！\n届け4人の組曲！スイートプリキュア！"
  :rhythm "レッツプレイ！プリキュアモジュレーション！！\n爪弾くはたおやかな調べ！ キュアリズム！\n届け4人の組曲！スイートプリキュア！"
  :beat "レッツプレイ！プリキュアモジュレーション！！\n爪弾くは魂の調べ！ キュアビート！\n届け4人の組曲！スイートプリキュア！"
  :muse "レッツプレイ！プリキュアモジュレーション！！\n爪弾くは女神の調べ！ キュアミューズ！\n届け4人の組曲！スイートプリキュア！"
  :happy "(レディ？)\nプリキュア・スマイルチャージ！\n(ゴー！ゴー！レッツ・ゴー！ハッピー！！)\nキラキラ輝く未来の光！ キュアハッピー！\n5つの光が導く未来！\n輝け！スマイルプリキュア！"
  :sunny "(レディ？)\nプリキュア・スマイルチャージ！\n(ゴー！ゴー！レッツ・ゴー！サニー！！)\n太陽サンサン熱血パワー！ キュアサニー！\n5つの光が導く未来！\n輝け！スマイルプリキュア！"
  :peace "(レディ？)\nプリキュア・スマイルチャージ！\n(ゴー！ゴー！レッツ・ゴー！ピース！！)\nピカピカピカリンジャンケンポン！ キュアピース！\n5つの光が導く未来！\n輝け！スマイルプリキュア！"
  :march "(レディ？)\nプリキュア・スマイルチャージ！\n(ゴー！ゴー！レッツ・ゴー！マーチ！！)\n勇気リンリン直球勝負！ キュアマーチ！\n5つの光が導く未来！\n輝け！スマイルプリキュア！"
  :beauty "(レディ？)\nプリキュア・スマイルチャージ！\n(ゴー！ゴー！レッツ・ゴー！ビューティ！！)\nしんしんと降り積もる清き心！ キュアビューティ！\n5つの光が導く未来！\n輝け！スマイルプリキュア！"
  :heart "プリキュアラブリンク！\nL! O! V! E!\nみなぎる愛！ キュアハート！\n響け愛の鼓動！ドキドキプリキュア！\n愛を無くした悲しいジコチューさん、\nこのキュアハートがあなたのドキドキ取り戻してみせる！"
  :echo "思いよ届け！\nキュアエコー！"
  :diamond "プリキュアラブリンク！\nL! O! V! E!\n英知の光！ キュアダイヤモンド！\n響け愛の鼓動！ドキドキプリキュア！\n人の思いを踏みにじるなんて許せない、\nこのキュアダイヤモンドがあなたの頭を冷やしてあげる！"
  :rosetta "プリキュアラブリンク！\nL! O! V! E!\nひだまりポカポカ キュアロゼッタ！\n響け愛の鼓動！ドキドキプリキュア！\n世界を制するのは愛だけです、\nさぁ、あなたも私と愛を育んでくださいな"
  :sword "プリキュアラブリンク！\nL! O! V! E!\n勇気の刃！ キュアソード！\n響け愛の鼓動！ドキドキプリキュア！\nこのキュアソードが愛の剣で\nあなたの野望を断ち切ってみせる！"
  :ace "プリキュアドレスアップ！\n(キュピラッパー！)\n愛の切り札！ キュアエース！\n響け愛の鼓動！ドキドキプリキュア！\n美しさは正義の証し、ウインク一つで、\nあなたのハートを射抜いて差し上げますわ"
  :lovely "(かわルンルン♪)プリキュア！くるりんミラーチェンジ！世界に広がるビッグな愛！キュアラブリー！"
  :princess "(かわルンルン♪)プリキュア！くるりんミラーチェンジ！天空に舞う蒼き風！キュアプリンセス！"
  :honey "(かわルンルン♪)プリキュア！くるりんミラーチェンジ！大地に実る命の光！キュアハニー！"
  :fortune "(かわルンルン♪)プリキュア！きらりんスターシンフォニー！夜空にきらめく希望の星！キュアフォーチュン！"
})

(defn transform
  ([human]
    (let [index (cond
                  (or (= saki human) (= mai human)) (rand-int 2)
                  :else 0)
          after (nth (:after-transforming human) index)]
      (println (transform-messages (keyword after)))
      (eval (symbol (str "clocure.core/" after)))))
  ([human adopsition & params]
    (if (= adopsition :with)
      (let [humans (sort-by :id (cons human (flatten params)))]
        (cond
          (= humans (sort-by :id [nagisa honoka]))
            (do
              (println "なぎさ・ほのか「デュアル・オーロラ・ウェイブ！！」\nブラック「光の使者、キュアブラック！」\nホワイト「光の使者、キュアホワイト！」\nブラック・ホワイト「ふたりはプリキュア！」\nホワイト「闇の力のしもべ達よ！」\nブラック「とっととお家に帰りなさい！」")
              [black white])
          (= humans (sort-by :id [saki mai]))
            (let [index (rand-int 2)]
              (println (nth [
                "咲・舞「デュアル・スピリチュアル・パワー！」\nブルーム「花開け大地に！」\nイーグレット「羽ばたけ空に！」\nブルーム「輝く金の花！ キュアブルーム！」\nイーグレット「煌めく銀の翼！ キュアイーグレット！」\nブルーム・イーグレット「ふたりはプリキュア！」\nイーグレット「聖なる泉を汚す者よ！」\nブルーム「阿漕な真似はお止めなさい！」"
                "咲・舞「デュアル・スピリチュアル・パワー！」\nブライト「未来を照らし！」\nウィンディ「勇気を運べ！」\nブライト「天空に満ちる月！ キュアブライト！」\nウィンディ「大地に薫る風！ キュアウィンディ！」\nブライト・ウィンディ「ふたりはプリキュア！」\nウィンディ「聖なる泉を汚す者よ！」\nブライト「阿漕な真似はお止めなさい！」"
              ] index))
              (nth [[bloom egret] [bright windy]] index))
          (= humans (sort-by :id [hibiki kanade]))
            (do
              (println "響・奏「レッツプレイ！プリキュアモジュレーション！！」\nメロディ「爪弾くは荒ぶる調べ！ キュアメロディ！」\nリズム「爪弾くはたおやかな調べ！ キュアリズム！」\nメロディ・リズム「届け！2人の組曲！スイートプリキュア！」")
              [melody rhythm])
          (= humans (sort-by :id [hibiki kanade ellen]))
            (do
              (println "響・奏・エレン「レッツプレイ！プリキュアモジュレーション！！」\nメロディ「爪弾くは荒ぶる調べ！ キュアメロディ！」\nリズム「爪弾くはたおやかな調べ！ キュアリズム！」\nビート「爪弾くは魂の調べ！ キュアビート！」\nメロディ・リズム・ビート「届け！3人の組曲！スイートプリキュア！」")
              [melody rhythm beat])
          (= humans (sort-by :id [hibiki kanade ellen ako]))
            (do
              (println "響・奏・エレン・アコ「レッツプレイ！プリキュアモジュレーション！！」\nメロディ「爪弾くは荒ぶる調べ！ キュアメロディ！」\nリズム「爪弾くはたおやかな調べ！ キュアリズム！」\nビート「爪弾くは魂の調べ！ キュアビート！」\nミューズ「爪弾くは女神の調べ！ キュアミューズ！」\nメロディ・リズム・ビート・ミューズ「届け！4人の組曲！スイートプリキュア！」")
              [melody rhythm beat muse])
          :else nil))
      nil)))

(def eas {
  :id 'eas
  :name "イース" :short-name "イース"
  :name-en "Eas"  :short-name-en "Eas"
  :before 'setsuna})
(defn switch-over [human]
  (if (= human setsuna)
    (do
      (println "スイッチオーバー！\n我が名はイース！\nラビリンス総統メビウス様が下僕！")
      eas)
    nil))
