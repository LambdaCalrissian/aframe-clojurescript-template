(ns aframe-clojurescript-template.core
    (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)

(defonce app-state (atom {:scene []}))

(defn reagent-template []
  [:div
   (:scene @app-state)])

(defn scene-template []
  [:a-scene
   [:a-sphere {:position "0 1.25 -5"
               :radius "1.25"
               :color "#EF2D5E"}]
   [:a-plane {:position "0 0 -4"
              :rotation "-90 0 0"
              :width "4"
              :height "4"
              :color "#7BC8A4"}]])

(swap! app-state #(assoc % :scene scene-template))

(reagent/render-component [scene-template]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
