
(ns arthur.core
  (:refer-clojure :exclude [==])
  (:use clojure.core.logic))

(defrel dev x)
(defrel pm x)
(defrel youngling x)
(defrel lead x)
(fact dev 'rod)
(fact dev 'gavd)
(fact dev 'craig)
(fact dev 'tidy)
(fact dev 'stevea)
(fact dev 'andy)
(fact dev 'alpha)
(fact dev 'kdawg)
(fact dev 'david)
(fact dev 'bendy)
(fact dev 'steff)
(fact pm 'pete)
(fact pm 'ines)
(fact pm 'ian)
(fact youngling 'kdawg)
(fact youngling 'steff)
(fact youngling 'bendy)
(fact lead 'gavd)
(fact lead 'craig)
(fact lead 'tidy)

(defn ^ {:doc "Teams are 3 people; 1 PM, 1 Lead and 1 Youngling"}
  teamo [xs]
  (conde
    ((fresh [x y ys z zs]
      (conso x ys xs)
      (conso y zs ys)
      (conso z () zs)
      (pm x)
      (lead y)
      (youngling z)
      (!= x y)
      (!= x z)
      (!= y z)))))

(defn teamso [xs]
  (conde
    ((== xs ()))
    ((fresh [x y]
      (conso x y xs)
      (teamo x)
      (teamso y)))))

(run 3 [q]
  (teamso q))

