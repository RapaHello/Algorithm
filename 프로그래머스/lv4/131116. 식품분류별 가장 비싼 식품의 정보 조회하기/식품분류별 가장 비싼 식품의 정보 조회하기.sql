-- 코드를 입력하세요
         SELECT B.CATEGORY
              , B.PRICE AS MAX_PRICE
              , B.PRODUCT_NAME
           FROM (SELECT CATEGORY
                      , MAX(PRICE) AS PRICE
                   FROM FOOD_PRODUCT
                  WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
               GROUP BY CATEGORY) A
LEFT OUTER JOIN FOOD_PRODUCT B
             ON A.CATEGORY = B.CATEGORY
            AND A.PRICE    = B.PRICE
       ORDER BY MAX_PRICE DESC
    