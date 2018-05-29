/*
 * Copyright 2018 JamesZBL
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package me.zbl.diulala;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 测试 Word 中文分词器
 *
 * @author JamesZBL
 * @email 1146556298@qq.com
 * @date 2018-05-26
 */
public class WordTest {

  @Test
  public void lucene() {
    String raw1 = "棕黄色";
    String raw2 = "我是棕黄色";
    String raw3 = "我是一名学生";
    String raw4 = "我是来自河北科技大学的一名学生";
    String raw5 = "我是来自石家庄的就读于河北科技大学的一名学生";
    List<String> list = Arrays.asList(raw1, raw2, raw3, raw4, raw5);
    list.forEach(w -> {
      List<Word> words = WordSegmenter.segWithStopWords(w);
      words.forEach(System.out::println);
    });
  }
}
