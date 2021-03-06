(ns clocure.core)

(defrecord Human
  [id
   name
   first-name      family-name
   first-name-kana family-name-kana
   first-name-en   family-name-en
   after-transforming])

; first-name-en is used as ID
(defmacro defhuman
  [first-name-en   family-name-en
   first-name      family-name
   first-name-kana family-name-kana
   & after-transforming]
  `(intern *ns*
    '~first-name-en ; ID
    (->Human
      '~first-name-en ; ID
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

; short-name-en is used as ID
(defmacro defprecure
  [short-name-en short-name before]
  `(intern *ns*
    '~short-name-en ; ID
    (->Precure
      '~short-name-en ; ID
      (str "キュア" '~short-name) (str '~short-name)
      (str "Cure " (clojure.string/capitalize '~short-name-en))
      (clojure.string/capitalize '~short-name-en)
      '~before)))

(defhuman nagisa   misumi     なぎさ 美墨   なぎさ   みすみ         black       )
(defhuman honoka   yukishiro  ほのか 雪城   ほのか   ゆきしろ       white       )
(defhuman hikari   kujo       ひかり 九条   ひかり   くじょう       luminous    )
(defhuman saki     hyuga      咲     日向   さき     ひゅうが       bloom bright)
(defhuman mai      misho      舞     美翔   まい     みしょう       egret windy )
(defhuman nozomi   yumehara   のぞみ 夢原   のぞみ   ゆめはら       dream       )
(defhuman rin      natsuki    りん   夏木   りん     なつき         rouge       )
(defhuman urara    kasugano   うらら 春日野 うらら   かすがの       lemonade    )
(defhuman komachi  akimoto    こまち 秋元   こまち   あきもと       mint        )
(defhuman karen    minazuki   かれん 水無月 かれん   みなづき       aqua        )
(defhuman kurumi   mimino     くるみ 美々野 くるみ   みみの         rose        )
(defhuman love     momozono   ラブ   桃園   らぶ     ももぞの       peach       )
(defhuman miki     aono       美希   蒼乃   みき     あおの         berry       )
(defhuman inori    yamabuki   祈里   山吹   いのり   やまぶき       pine        )
(defhuman setsuna  higashi    せつな 東     せつな   ひがし         passion     )
(defhuman tsubomi  hanasaki   つぼみ 花咲   つぼみ   はなさき       blossom     )
(defhuman erika    kurumi     えりか 来海   えりか   くるみ         marine      )
(defhuman itsuki   myodoin    いつき 明堂院 いつき   みょうどういん sunshine    )
(defhuman yuri     tsukikage  ゆり   月影   ゆり     つきかげ       moonlight   )
(defhuman hibiki   hojo       響     北条   ひびき   ほうじょう     melody      )
(defhuman kanade   minamino   奏     南野   かなで   みなみの       rhythm      )
(defhuman ellen    kurokawa   エレン 黒川   えれん   くろかわ       beat        )
(defhuman ako      shirabe    アコ   調辺   あこ     しらべ         muse        )
(defhuman miyuki   hoshizora  みゆき 星空   みゆき   ほしぞら       happy       )
(defhuman akane    hino       あかね 日野   あかね   ひの           sunny       )
(defhuman yayoi    kise       やよい 黄瀬   やよい   きせ           peace       )
(defhuman nao      midorikawa なお   緑川   なお     みどりかわ     march       )
(defhuman reika    aoki       れいか 青木   れいか   あおき         beauty      )
(defhuman ayumi    sakagami   あゆみ 坂上   あゆみ   さかがみ       echo        )
(defhuman mana     aida       マナ   相田   まな     あいだ         heart       )
(defhuman rikka    hishikawa  六花   菱川   りっか   ひしかわ       diamond     )
(defhuman arisu    yotsuba    ありす 四葉   ありす   よつば         rosetta     )
(defhuman makoto   kenzaki    真琴   剣崎   まこと   けんざき       sword       )
(defhuman aguri    madoka     亜久里 円     あぐり   まどか         ace         )
(defhuman megumi   aino       めぐみ 愛乃   めぐみ   あいの         lovely      )
(defhuman hime     shirayuki  ひめ   白雪   ひめ     しらゆき       princess    )
(defhuman yuko     omori      ゆうこ 大森   ゆうこ   おおもり       honey       )
(defhuman iona     hikawa     いおな 氷川   いおな   ひかわ         fortune     )
(defhuman haruka   haruno     はるか 春野   はるか   はるの         flora       )
(defhuman minami   kaido      みなみ 海藤   みなみ   かいどう       mermaid     )
(defhuman kirara   amanogawa  きらら 天ノ川 きらら   あまのがわ     twinkle     )
(defhuman towa     akagi      トワ   紅城   とわ     あかぎ         scarlet     )
(defhuman mirai    asahina    みらい 朝日奈 みらい   あさひな       miracle     )
(defhuman riko     izayoi     リコ   十六夜 りこ     いざよい       magical     )
(defhuman kotoha   hanami     ことは 花海   ことは   はなみ         felice      )
(def ohana
  (->Human
    'ohana
    "オハナ"
    "Ohana" nil
    "オハナ" nil
    "おはな" nil
    ['sunset]))
(def orina
  (->Human
    'orina
    "オリナ"
    "Orina" nil
    "オリナ" nil
    "おりな" nil
    ['wave]))

(defprecure black     ブラック     nagisa  )
(defprecure white     ホワイト     honoka  )
(defprecure bloom     ブルーム     saki    )
(defprecure egret     イーグレット mai     )
(defprecure bright    ブライト     saki    )
(defprecure windy     ウィンディ   mai     )
(defprecure dream     ドリーム     nozomi  )
(defprecure rouge     ルージュ     rin     )
(defprecure lemonade  レモネード   urara   )
(defprecure mint      ミント       komachi )
(defprecure aqua      アクア       karen   )
(defprecure peach     ピーチ       love    )
(defprecure berry     ベリー       miki    )
(defprecure pine      パイン       inori   )
(defprecure passion   パッション   setsuna )
(defprecure blossom   ブロッサム   tsubomi )
(defprecure marine    マリン       erika   )
(defprecure sunshine  サンシャイン itsuki  )
(defprecure moonlight ムーンライト yuri    )
(defprecure melody    メロディ     hibiki  )
(defprecure rhythm    リズム       kanade  )
(defprecure beat      ビート       ellen   )
(defprecure muse      ミューズ     ako     )
(defprecure happy     ハッピー     miyuki  )
(defprecure sunny     サニー       akane   )
(defprecure peace     ピース       yayoi   )
(defprecure march     マーチ       nao     )
(defprecure beauty    ビューティ   reika   )
(defprecure echo      エコー       ayumi   )
(defprecure heart     ハート       mana    )
(defprecure diamond   ダイヤモンド rikka   )
(defprecure rosetta   ロゼッタ     arisu   )
(defprecure sword     ソード       makoto  )
(defprecure ace       エース       aguri   )
(defprecure lovely    ラブリー     megumi  )
(defprecure princess  プリンセス   hime    )
(defprecure honey     ハニー       yuko    )
(defprecure fortune   フォーチュン iona    )
(defprecure sunset    サンセット   ohana   )
(defprecure wave      ウェーブ     orina   )
(defprecure flora     フローラ     haruka  )
(defprecure mermaid   マーメイド   minami  )
(defprecure twinkle   トゥインクル kirara  )
(defprecure scarlet   スカーレット towa    )
(defprecure miracle   ミラクル     mirai   )
(defprecure magical   マジカル     riko    )
(defprecure felice    フェリーチェ kotoha  )
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
  :lovely "(かわルンルン♪)プリキュア！くるりんミラーチェンジ！世界に広がるビッグな愛！キュアラブリー！ハピネス注入！幸せチャージ！ハピネスチャージプリキュア！"
  :princess "(かわルンルン♪)プリキュア！くるりんミラーチェンジ！天空に舞う蒼き風！キュアプリンセス！ハピネス注入！幸せチャージ！ハピネスチャージプリキュア！"
  :honey "(かわルンルン♪)プリキュア！くるりんミラーチェンジ！大地に実る命の光！キュアハニー！ハピネス注入！幸せチャージ！ハピネスチャージプリキュア！"
  :fortune "(かわルンルン♪)プリキュア！きらりんスターシンフォニー！夜空にきらめく希望の星！キュアフォーチュン！ハピネス注入！幸せチャージ！ハピネスチャージプリキュア！"
  :sunset "(かわルンルン♪)プリキュア！くるりんミラーチェンジ！紅い夕日は明日への誓い！キュアサンセット！南国に輝く二つの光！アローハプリキュア！"
  :wave "(かわルンルン♪)プリキュア！くるりんミラーチェンジ！寄せては返す悠久の調べ！キュアウェーブ！南国に輝く二つの光！アローハプリキュア！"
  :flora "プリキュア！プリンセスエンゲージ！咲き誇る花のプリンセス！キュアフローラ！"
  :mermaid "プリキュア！プリンセスエンゲージ！澄み渡る海のプリンセス！キュアマーメイド！"
  :twinkle "プリキュア！プリンセスエンゲージ！きらめく星のプリンセス！キュアトゥインクル！"
  :scarlet "プリキュア！プリンセスエンゲージ！真紅の炎のプリンセス！キュアスカーレット！"
  :miracle "キュアップ・ラパパ！ミラクル・マジカル・ジュエリーレ！ふたりの奇跡！キュアミラクル！"
  :magical "キュアップ・ラパパ！ミラクル・マジカル・ジュエリーレ！ふたりの魔法！キュアマジカル！"
  :felice "キュアップ・ラパパ！フェリーチェ・ファンファン・フラワーレ！あまねく命に祝福を！キュアフェリーチェ！"
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
          (= humans (sort-by :id [ohana orina]))
            (do
              (println "(かわルンルン♪)\nオハナ・オリナ「プリキュア！くるりんミラーチェンジ！」\nサンセット「紅い夕日は明日への誓い！キュアサンセット！」\nウェーブ「寄せては返す悠久の調べ！キュアウェーブ！」\nサンセット・ウェーブ「南国に輝く二つの光！アローハプリキュア！」")
              [sunset wave])
          (= humans (sort-by :id [haruka minami kirara]))
            (do
              (println "はるか・みなみ・きらら「プリキュア！プリンセスエンゲージ！」\nフローラ「咲き誇る花のプリンセス！キュアフローラ！」\nマーメイド「澄み渡る海のプリンセス！キュアマーメイド！」\nトゥインクル「きらめく星のプリンセス！キュアトゥインクル！」\nフローラ「つよく！」\nマーメイド「やさしく！」\nトゥインクル「美しく！」\nフローラ・マーメイド・トゥインクル「Go!プリンセスプリキュア！」")
              [flora mermaid twinkle])
          (= humans (sort-by :id [haruka minami kirara towa]))
            (do
              (println "はるか・みなみ・きらら・トワ「プリキュア！プリンセスエンゲージ！」\nフローラ「咲き誇る花のプリンセス！キュアフローラ！」\nマーメイド「澄み渡る海のプリンセス！キュアマーメイド！」\nトゥインクル「きらめく星のプリンセス！キュアトゥインクル！」\nスカーレット「真紅の炎のプリンセス！キュアスカーレット！」\nフローラ「つよく！」\nマーメイド「やさしく！」\nトゥインクル「美しく！」\nスカーレット「Go!」\nフローラ・マーメイド・トゥインクル・スカーレット「プリンセスプリキュア！」")
              [flora mermaid twinkle scarlet])
          (= humans (sort-by :id [mirai riko]))
            (do
              (println "みらい・リコ「キュアップ・ラパパ！ミラクル・マジカル・ジュエリーレ！」\nミラクル「ふたりの奇跡！キュアミラクル！」\nマジカル「ふたりの魔法！キュアマジカル！」\nミラクル・マジカル「魔法つかいプリキュア！」")
              [miracle magical])
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
