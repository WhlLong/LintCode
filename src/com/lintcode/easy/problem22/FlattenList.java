/**
 * Copyright (C), 2015-2019, 章鱼云商
 * FileName: FlattenList
 * Author:   wanghuailong
 * Date:     2019/1/18 11:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lintcode.easy.problem22;

/**
 * 〈〉
 *
 * @author wanghuailong
 * @create 2019/1/18
 * @since 1.0.0
 */
public class FlattenList {

    /*
    *     public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        if(nestedList == null){
            return null;
        }

        boolean hasList = true;
        while(hasList){
            List<NestedInteger> nestedIntegerList = new ArrayList<>();
            hasList = false;
            for(NestedInteger nestedInteger : nestedList){
                if(nestedInteger.isInteger()){
                    nestedIntegerList.add(nestedInteger);
                }else{
                    nestedIntegerList.addAll(nestedInteger.getList());
                    hasList = true;
                }
            }

            nestedList = nestedIntegerList;
        }


         List<Integer> list = new ArrayList<>();
         for(NestedInteger nestedInteger : nestedList){
             list.add(nestedInteger.getInteger());
         }

        return list;
    }
    * */



    //优化后:
    /*
     public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        if(nestedList == null){
            return null;
        }
        if(nestedList.size() == 0){
            return new ArrayList<>(0);
        }

        boolean hasList = true;
        while(hasList){
            hasList = false;
            for(int i=0;i<nestedList.size();i++){
                // NestedInteger nestedInteger = nestedList.get(i);

                if(!nestedList.get(i).isInteger()){

                    nestedList.addAll(i+1,nestedList.get(i).getList());
                    nestedList.remove(i);
                    hasList = true;
                }

            }

            // nestedList = nestedIntegerList;
        }


         List<Integer> list = new ArrayList<>();
         for(NestedInteger nestedInteger : nestedList){
             list.add(nestedInteger.getInteger());
         }

        return list;
    }
     */

}