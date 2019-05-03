(ns xlsx-db.core
  (:require ["blessed" :as blessed]
            ["react-blessed" :refer [render]]
            [reagent.core :as r]))

(def screen (. blessed screen #js {:autoPadding true
                                   :smartCSR true
                                   :title "XLSX Database"}))

(defn main [ & args]
  (. screen key #js ["escape", "q", "C-c"]
    #(. js/process exit 0)))

(defn box []
  [:box {:top "center"
         :left "center"
         :width "50%"
         :height "50%"
         :border {:type "line"}
         :style {:border {:fg "blue"}}}
   "Hello LOL!"]
  [:listtable {:top "center"
               :data (mapv #(vector (str %) (str %)) (range 100))
               :vi true
               :tags true
               :keys true
               :mouse true
                :left "center"
                :width "50%"
                :height "50%"
                :border {:type "line"}
                :style {:border {:fg "red"}
                        :cell {:fg "magenta"
                               :selected {:bg "blue"}}}}])

(def component (render (r/as-component [box]) screen))


(defn reload []
  (prn :RELOAD)
  (prn render))
