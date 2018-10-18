package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class cc {
    public static final cd pQ = new C09171();
    public static final cd pR = new C09182();
    public static final cd pS = new C09193();
    public static final cd pT = new C09204();
    public static final cd pU = new C09215();
    public static final cd pV = new C09226();
    public static final cd pW = new C09237();
    public static final cd pX = new C09248();
    public static final cd pY = new C09259();
    public static final cd pZ = new cj();

    /* renamed from: com.google.android.gms.internal.cc$1 */
    static class C09171 implements cd {
        C09171() {
        }

        /* renamed from: a */
        public void mo1660a(gu guVar, Map<String, String> map) {
        }
    }

    /* renamed from: com.google.android.gms.internal.cc$2 */
    static class C09182 implements cd {
        C09182() {
        }

        /* renamed from: a */
        public void mo1660a(gu guVar, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                gr.m1341W("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = guVar.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) != null));
            }
            guVar.m1355a("openableURLs", hashMap);
        }
    }

    /* renamed from: com.google.android.gms.internal.cc$3 */
    static class C09193 implements cd {
        C09193() {
        }

        /* renamed from: a */
        public void mo1660a(gu guVar, Map<String, String> map) {
            PackageManager packageManager = guVar.getContext().getPackageManager();
            try {
                try {
                    JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("id");
                            Object optString2 = jSONObject2.optString("u");
                            Object optString3 = jSONObject2.optString("i");
                            Object optString4 = jSONObject2.optString("m");
                            Object optString5 = jSONObject2.optString("p");
                            Object optString6 = jSONObject2.optString("c");
                            jSONObject2.optString("f");
                            jSONObject2.optString("e");
                            Intent intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                            try {
                                jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                            } catch (Throwable e) {
                                gr.m1343b("Error constructing openable urls response.", e);
                            }
                        } catch (Throwable e2) {
                            gr.m1343b("Error parsing the intent data.", e2);
                        }
                    }
                    guVar.m1357b("openableIntents", jSONObject);
                } catch (JSONException e3) {
                    guVar.m1357b("openableIntents", new JSONObject());
                }
            } catch (JSONException e4) {
                guVar.m1357b("openableIntents", new JSONObject());
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.cc$4 */
    static class C09204 implements cd {
        C09204() {
        }

        /* renamed from: a */
        public void mo1660a(gu guVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                gr.m1341W("URL missing from click GMSG.");
                return;
            }
            Uri a;
            Uri parse = Uri.parse(str);
            try {
                C0484k dF = guVar.dF();
                if (dF != null && dF.m1595b(parse)) {
                    a = dF.m1592a(parse, guVar.getContext());
                    new gp(guVar.getContext(), guVar.dG().wS, a.toString()).start();
                }
            } catch (C0486l e) {
                gr.m1341W("Unable to append parameter to URL: " + str);
            }
            a = parse;
            new gp(guVar.getContext(), guVar.dG().wS, a.toString()).start();
        }
    }

    /* renamed from: com.google.android.gms.internal.cc$5 */
    static class C09215 implements cd {
        C09215() {
        }

        /* renamed from: a */
        public void mo1660a(gu guVar, Map<String, String> map) {
            dp dC = guVar.dC();
            if (dC == null) {
                gr.m1341W("A GMSG tried to close something that wasn't an overlay.");
            } else {
                dC.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.cc$6 */
    static class C09226 implements cd {
        C09226() {
        }

        /* renamed from: a */
        public void mo1660a(gu guVar, Map<String, String> map) {
            guVar.m1358q("1".equals(map.get("custom_close")));
        }
    }

    /* renamed from: com.google.android.gms.internal.cc$7 */
    static class C09237 implements cd {
        C09237() {
        }

        /* renamed from: a */
        public void mo1660a(gu guVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                gr.m1341W("URL missing from httpTrack GMSG.");
            } else {
                new gp(guVar.getContext(), guVar.dG().wS, str).start();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.cc$8 */
    static class C09248 implements cd {
        C09248() {
        }

        /* renamed from: a */
        public void mo1660a(gu guVar, Map<String, String> map) {
            gr.m1339U("Received log message: " + ((String) map.get("string")));
        }
    }

    /* renamed from: com.google.android.gms.internal.cc$9 */
    static class C09259 implements cd {
        C09259() {
        }

        /* renamed from: a */
        public void mo1660a(gu guVar, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                C0484k dF = guVar.dF();
                if (dF != null) {
                    dF.m1591C().mo1800a(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                gr.m1341W("Could not parse touch parameters from gmsg.");
            }
        }
    }
}
