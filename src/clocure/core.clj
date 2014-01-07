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
;(def-precure honey     ハニー               )
;(def-precure fortune   フォーチュン         )

(defn transform [human]
  (let [index (cond
                (or (= saki human) (= mai human)) (rand-int 2)
                :else 0)]
    (eval (symbol (str "clocure.core/"
                    (nth (.after-transforming human) index))))))
