package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.C0144y.C0143a;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HitBuilders {

    protected static class HitBuilder<T extends HitBuilder> {
        private Map<String, String> BA = new HashMap();
        ProductAction BB;
        Map<String, List<Product>> BC = new HashMap();
        List<Promotion> BD = new ArrayList();
        List<Product> BE = new ArrayList();

        protected HitBuilder() {
        }

        public T addImpression(Product product, String impressionList) {
            if (product == null) {
                ae.m45W("product should be non-null");
            } else {
                if (impressionList == null) {
                    impressionList = "";
                }
                if (!this.BC.containsKey(impressionList)) {
                    this.BC.put(impressionList, new ArrayList());
                }
                ((List) this.BC.get(impressionList)).add(product);
            }
            return this;
        }

        public T addProduct(Product product) {
            if (product == null) {
                ae.m45W("product should be non-null");
            } else {
                this.BE.add(product);
            }
            return this;
        }

        public T addPromotion(Promotion promotion) {
            if (promotion == null) {
                ae.m45W("promotion should be non-null");
            } else {
                this.BD.add(promotion);
            }
            return this;
        }

        public Map<String, String> build() {
            Map<String, String> hashMap = new HashMap(this.BA);
            if (this.BB != null) {
                hashMap.putAll(this.BB.build());
            }
            int i = 1;
            for (Promotion aq : this.BD) {
                hashMap.putAll(aq.aq(C0127s.m72B(i)));
                i++;
            }
            i = 1;
            for (Product aq2 : this.BE) {
                hashMap.putAll(aq2.aq(C0127s.m71A(i)));
                i++;
            }
            int i2 = 1;
            for (Entry entry : this.BC.entrySet()) {
                List<Product> list = (List) entry.getValue();
                String D = C0127s.m74D(i2);
                int i3 = 1;
                for (Product aq3 : list) {
                    hashMap.putAll(aq3.aq(D + C0127s.m73C(i3)));
                    i3++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    hashMap.put(D + "nm", entry.getKey());
                }
                i2++;
            }
            return hashMap;
        }

        protected String get(String paramName) {
            return (String) this.BA.get(paramName);
        }

        public final T set(String paramName, String paramValue) {
            C0144y.eK().m86a(C0143a.MAP_BUILDER_SET);
            if (paramName != null) {
                this.BA.put(paramName, paramValue);
            } else {
                ae.m45W(" HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public final T setAll(Map<String, String> params) {
            C0144y.eK().m86a(C0143a.MAP_BUILDER_SET_ALL);
            if (params != null) {
                this.BA.putAll(new HashMap(params));
            }
            return this;
        }

        public T setCampaignParamsFromUrl(String utmParams) {
            C0144y.eK().m86a(C0143a.MAP_BUILDER_SET_CAMPAIGN_PARAMS);
            Object ao = an.ao(utmParams);
            if (!TextUtils.isEmpty(ao)) {
                Map an = an.an(ao);
                set("&cc", (String) an.get("utm_content"));
                set("&cm", (String) an.get("utm_medium"));
                set("&cn", (String) an.get("utm_campaign"));
                set("&cs", (String) an.get("utm_source"));
                set("&ck", (String) an.get("utm_term"));
                set("&ci", (String) an.get("utm_id"));
                set("&gclid", (String) an.get("gclid"));
                set("&dclid", (String) an.get("dclid"));
                set("&gmob_t", (String) an.get("gmob_t"));
            }
            return this;
        }

        public T setCustomDimension(int index, String dimension) {
            set(C0127s.m78y(index), dimension);
            return this;
        }

        public T setCustomMetric(int index, float metric) {
            set(C0127s.m79z(index), Float.toString(metric));
            return this;
        }

        protected T setHitType(String hitType) {
            set("&t", hitType);
            return this;
        }

        public T setNewSession() {
            set("&sc", "start");
            return this;
        }

        public T setNonInteraction(boolean nonInteraction) {
            set("&ni", an.m52E(nonInteraction));
            return this;
        }

        public T setProductAction(ProductAction action) {
            this.BB = action;
            return this;
        }

        public T setPromotionAction(String action) {
            this.BA.put("&promoa", action);
            return this;
        }
    }

    @Deprecated
    public static class AppViewBuilder extends HitBuilder<AppViewBuilder> {
        public AppViewBuilder() {
            C0144y.eK().m86a(C0143a.CONSTRUCT_APP_VIEW);
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class EventBuilder extends HitBuilder<EventBuilder> {
        public EventBuilder() {
            C0144y.eK().m86a(C0143a.CONSTRUCT_EVENT);
            set("&t", DataLayer.EVENT_KEY);
        }

        public EventBuilder(String category, String action) {
            this();
            setCategory(category);
            setAction(action);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public EventBuilder setAction(String action) {
            set("&ea", action);
            return this;
        }

        public EventBuilder setCategory(String category) {
            set("&ec", category);
            return this;
        }

        public EventBuilder setLabel(String label) {
            set("&el", label);
            return this;
        }

        public EventBuilder setValue(long value) {
            set("&ev", Long.toString(value));
            return this;
        }
    }

    public static class ExceptionBuilder extends HitBuilder<ExceptionBuilder> {
        public ExceptionBuilder() {
            C0144y.eK().m86a(C0143a.CONSTRUCT_EXCEPTION);
            set("&t", "exception");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ExceptionBuilder setDescription(String description) {
            set("&exd", description);
            return this;
        }

        public ExceptionBuilder setFatal(boolean fatal) {
            set("&exf", an.m52E(fatal));
            return this;
        }
    }

    @Deprecated
    public static class ItemBuilder extends HitBuilder<ItemBuilder> {
        public ItemBuilder() {
            C0144y.eK().m86a(C0143a.CONSTRUCT_ITEM);
            set("&t", "item");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ItemBuilder setCategory(String category) {
            set("&iv", category);
            return this;
        }

        public ItemBuilder setCurrencyCode(String currencyCode) {
            set("&cu", currencyCode);
            return this;
        }

        public ItemBuilder setName(String name) {
            set("&in", name);
            return this;
        }

        public ItemBuilder setPrice(double price) {
            set("&ip", Double.toString(price));
            return this;
        }

        public ItemBuilder setQuantity(long quantity) {
            set("&iq", Long.toString(quantity));
            return this;
        }

        public ItemBuilder setSku(String sku) {
            set("&ic", sku);
            return this;
        }

        public ItemBuilder setTransactionId(String transactionid) {
            set("&ti", transactionid);
            return this;
        }
    }

    public static class ScreenViewBuilder extends HitBuilder<ScreenViewBuilder> {
        public ScreenViewBuilder() {
            C0144y.eK().m86a(C0143a.CONSTRUCT_APP_VIEW);
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class SocialBuilder extends HitBuilder<SocialBuilder> {
        public SocialBuilder() {
            C0144y.eK().m86a(C0143a.CONSTRUCT_SOCIAL);
            set("&t", "social");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public SocialBuilder setAction(String action) {
            set("&sa", action);
            return this;
        }

        public SocialBuilder setNetwork(String network) {
            set("&sn", network);
            return this;
        }

        public SocialBuilder setTarget(String target) {
            set("&st", target);
            return this;
        }
    }

    public static class TimingBuilder extends HitBuilder<TimingBuilder> {
        public TimingBuilder() {
            C0144y.eK().m86a(C0143a.CONSTRUCT_TIMING);
            set("&t", "timing");
        }

        public TimingBuilder(String category, String variable, long value) {
            this();
            setVariable(variable);
            setValue(value);
            setCategory(category);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TimingBuilder setCategory(String category) {
            set("&utc", category);
            return this;
        }

        public TimingBuilder setLabel(String label) {
            set("&utl", label);
            return this;
        }

        public TimingBuilder setValue(long value) {
            set("&utt", Long.toString(value));
            return this;
        }

        public TimingBuilder setVariable(String variable) {
            set("&utv", variable);
            return this;
        }
    }

    @Deprecated
    public static class TransactionBuilder extends HitBuilder<TransactionBuilder> {
        public TransactionBuilder() {
            C0144y.eK().m86a(C0143a.CONSTRUCT_TRANSACTION);
            set("&t", "transaction");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TransactionBuilder setAffiliation(String affiliation) {
            set("&ta", affiliation);
            return this;
        }

        public TransactionBuilder setCurrencyCode(String currencyCode) {
            set("&cu", currencyCode);
            return this;
        }

        public TransactionBuilder setRevenue(double revenue) {
            set("&tr", Double.toString(revenue));
            return this;
        }

        public TransactionBuilder setShipping(double shipping) {
            set("&ts", Double.toString(shipping));
            return this;
        }

        public TransactionBuilder setTax(double tax) {
            set("&tt", Double.toString(tax));
            return this;
        }

        public TransactionBuilder setTransactionId(String transactionid) {
            set("&ti", transactionid);
            return this;
        }
    }
}
