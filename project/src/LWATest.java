/* File:    LWATest.java
 * Created: 2017-01-17
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 WorldLingo Inc.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Insert Description of the Class
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class LWATest {

  public static void main(String[] args) throws Exception {
    String original = "en,lwa_it,lwa_cs,lwa_nl,lwa_et,lwa_uk,lwa_pl,lwa_es,lwa_ps,lwa_el,lwa_pt,lwa_ja,lwa_no,lwa_id,lwa_ru,lwa_zh_tw,lwa_lt,lwa_ro,lwa_lv,lwa_tr,lwa_ar,lwa_th,lwa_hu,lwa_ko,lwa_vi,lwa_ms,lwa_fr,lwa_zh_cn,lwa_dr,lwa_bn,lwa_he,lwa_sv,lwa_ha,lwa_sr,lwa_bg,lwa_de,lwa_fa,lwa_so,lwa_da,lwa_sq,lwa_sk,lwa_hi,lwa_fi,lwa_ur";
    String changed =  "en,lwa_ar,lwa_bg,lwa_bn,lwa_zh_cn,lwa_zh_tw,lwa_cs,lwa_da,lwa_de,lwa_dr,lwa_el,lwa_es,lwa_et,lwa_fa,lwa_fi,lwa_fr,lwa_ha,lwa_he,lwa_hi,lwa_hu,lwa_id,lwa_it,lwa_ja,lwa_ko,lwa_lt,lwa_lv,lwa_ms,lwa_no,lwa_nl,lwa_pl,lwa_ps,lwa_pt,lwa_ro,lwa_ru,lwa_sk,lwa_so,lwa_sq,lwa_sr,lwa_sv,lwa_th,lwa_tr,lwa_uk,lwa_ur,lwa_vi";

    List<String> langs = new ArrayList<String>();

    for (String lang : original.split(",")) {
      langs.add(lang);
    }

    for (String lang : changed.split(",")) {
      if(!langs.remove(lang)) {
        throw new Exception("did not find" + lang);
      }
    }

    if (langs.size() > 0) {
      throw new Exception("some elements left" + langs.size());
    }
  }
} // LWATest
