package au.com.adszew.okitransport.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.adszew.okitransport.model.Route;
import au.com.adszew.okitransport.model.Stop;

/**
 * DummyDataSource that will be used for development purposes.
 */
public class DummyDataSource implements RouteDataSource {

    private int sequenceId = 0;

    private List<Stop>  mStops;
    private Map<String, Route> mRoutes;

    private Route createRoute(final String routeName, final String operator) {
        return new Route("" + sequenceId++, routeName, operator);
    }

    /**
     * Load the routes into memory; ideally these would be stored in disk, database, or
     * available from a web service call.
     */
    @Override
    public void initialise() {
        mStops = new ArrayList<Stop>();
        mStops.add(new Stop("NAHA Bus terminal", "NAHA Bus terminal"));
        mStops.add(new Stop("KENCHO KITAGUCHI", "KENCHO KITAGUCHI"));
        mStops.add(new Stop("MATSUO", "MATSUO"));
        mStops.add(new Stop("MAKISHI", "MAKISHI"));
        mStops.add(new Stop("ASATO", "ASATO"));
        mStops.add(new Stop("SOGENJI", "SOGENJI"));
        mStops.add(new Stop("NAKANOHASHI", "NAKANOHASHI"));
        mStops.add(new Stop("TOMARI TAKAHASHI", "TOMARI TAKAHASHI"));
        mStops.add(new Stop("NORIN CHUKIN MAE", "NORIN CHUKIN MAE"));
        mStops.add(new Stop("WAKAMATSU IRIGUCHI", "WAKAMATSU IRIGUCHI"));
        mStops.add(new Stop("TOMARI TAKAHASHI", "TOMARI TAKAHASHI"));
        mStops.add(new Stop("UENOYA", "UENOYA"));
        mStops.add(new Stop("DAIICHI AMEKU", "DAIICHI AMEKU"));
        mStops.add(new Stop("AMEKU", "AMEKU"));
        mStops.add(new Stop("AJA", "AJA"));
        mStops.add(new Stop("AJABASHI", "AJABASHI"));
        mStops.add(new Stop("JITCHAKU", "JITCHAKU"));
        mStops.add(new Stop("DAIICHI NAKANISHI", "DAIICHI NAKANISHI"));
        mStops.add(new Stop("NAKANISHI", "NAKANISHI"));
        mStops.add(new Stop("MIYAGI", "MIYAGI"));
        mStops.add(new Stop("YAFUSO", "YAFUSO"));
        mStops.add(new Stop("GUSUKUMA", "GUSUKUMA"));
        mStops.add(new Stop("DAINI GUSUKUMA", "DAINI GUSUKUMA"));
        mStops.add(new Stop("MINATOGAWA", "MINATOGAWA"));
        mStops.add(new Stop("DAIICHI MAKIMINATO", "DAIICHI MAKIMINATO"));
        mStops.add(new Stop("MAKIMINATO", "MAKIMINATO"));
        mStops.add(new Stop("UCHIDOMARI", "UCHIDOMARI"));
        mStops.add(new Stop("OJANA", "OJANA"));
        mStops.add(new Stop("MASHIKI", "MASHIKI"));
        mStops.add(new Stop("DAIICHI OYAMA", "DAIICHI OYAMA"));
        mStops.add(new Stop("OYAMA", "OYAMA"));
        mStops.add(new Stop("ISA", "ISA"));
        mStops.add(new Stop("ISAGAWA", "ISAGAWA"));
        mStops.add(new Stop("ISAHAMA", "ISAHAMA"));
        mStops.add(new Stop("KITAMAE", "KITAMAE"));
        mStops.add(new Stop("CHATAN", "CHATAN"));
        mStops.add(new Stop("JARGARU IRIGUCHI", "JARGARU IRIGUCHI"));
        mStops.add(new Stop("GUN BYOIN MAE", "GUN BYOIN MAE"));
        mStops.add(new Stop("KUWAE", "KUWAE"));
        mStops.add(new Stop("IHEI", "IHEI"));
        mStops.add(new Stop("KOKUTAI IRIGUCHI", "KOKUTAI IRIGUCHI"));
        mStops.add(new Stop("SUNABE", "SUNABE"));
        mStops.add(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        mStops.add(new Stop("MIZUGAMA", "MIZUGAMA"));
        mStops.add(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        mStops.add(new Stop("KADENA", "KADENA"));
        mStops.add(new Stop("OWAN", "OWAN"));
        mStops.add(new Stop("HIJA", "HIJA"));
        mStops.add(new Stop("HIJAKUSHIBARU", "HIJAKUSHIBARU"));
        mStops.add(new Stop("IRAMINA", "IRAMINA"));
        mStops.add(new Stop("OKI", "OKI"));
        mStops.add(new Stop("FURUGEN SHOGAKKO IRIGUCHI", "FURUGEN SHOGAKKO IRIGUCHI"));
        mStops.add(new Stop("AKANUKUU MAE", "AKANUKUU MAE"));
        mStops.add(new Stop("OZOE", "OZOE"));
        mStops.add(new Stop("SOBE", "SOBE"));
        mStops.add(new Stop("TOYA", "TOYA"));
        mStops.add(new Stop("YOMITAN SHINRYOJO MAE", "YOMITAN SHINRYOJO MAE"));
        mStops.add(new Stop("UFUDO", "UFUDO"));
        mStops.add(new Stop("NAMIHIRA", "NAMIHIRA"));
        mStops.add(new Stop("TAKASHIHO IRIGUCHI", "TAKASHIHO IRIGUCHI"));
        mStops.add(new Stop("TAKASHIHO", "TAKASHIHO"));
        mStops.add(new Stop("UZA KOMINKAN MAE", "UZA KOMINKAN MAE"));
        mStops.add(new Stop("SENAHA IRIGUCHI", "SENAHA IRIGUCHI"));
        mStops.add(new Stop("YOMITAN Bus terminal", "YOMITAN Bus terminal"));

        mRoutes = new HashMap<String, Route>();

        final Route route29 = createRoute("29", "琉球バス");

        route29.addStop(new Stop("NAHA Bus terminal", "NAHA Bus terminal"));
        route29.addStop(new Stop("KENCHO KITAGUCHI", "KENCHO KITAGUCHI"));
        route29.addStop(new Stop("MATSUO", "MATSUO"));
        route29.addStop(new Stop("MAKISHI", "MAKISHI"));
        route29.addStop(new Stop("ASATO", "ASATO"));
        route29.addStop(new Stop("SOGENJI", "SOGENJI"));
        route29.addStop(new Stop("NAKANOHASHI", "NAKANOHASHI"));
        route29.addStop(new Stop("TOMARI TAKAHASHI", "TOMARI TAKAHASHI"));
        route29.addStop(new Stop("NORIN CHUKIN MAE", "NORIN CHUKIN MAE"));
        route29.addStop(new Stop("WAKAMATSU IRIGUCHI", "WAKAMATSU IRIGUCHI"));
        route29.addStop(new Stop("TOMARI TAKAHASHI", "TOMARI TAKAHASHI"));
        route29.addStop(new Stop("UENOYA", "UENOYA"));
        route29.addStop(new Stop("DAIICHI AMEKU", "DAIICHI AMEKU"));
        route29.addStop(new Stop("AMEKU", "AMEKU"));
        route29.addStop(new Stop("AJA", "AJA"));
        route29.addStop(new Stop("AJABASHI", "AJABASHI"));

        mRoutes.put(route29.getId(), route29);

        final Route route28 = createRoute("28", "琉球バス");
        route28.addStop(new Stop("AJABASHI", "AJABASHI"));
        route28.addStop(new Stop("JITCHAKU", "JITCHAKU"));
        route28.addStop(new Stop("DAIICHI NAKANISHI", "DAIICHI NAKANISHI"));
        route28.addStop(new Stop("NAKANISHI", "NAKANISHI"));
        route28.addStop(new Stop("MIYAGI", "MIYAGI"));
        route28.addStop(new Stop("YAFUSO", "YAFUSO"));
        route28.addStop(new Stop("GUSUKUMA", "GUSUKUMA"));
        route28.addStop(new Stop("DAINI GUSUKUMA", "DAINI GUSUKUMA"));
        route28.addStop(new Stop("MINATOGAWA", "MINATOGAWA"));
        route28.addStop(new Stop("DAIICHI MAKIMINATO", "DAIICHI MAKIMINATO"));
        route28.addStop(new Stop("MAKIMINATO", "MAKIMINATO"));
        route28.addStop(new Stop("UCHIDOMARI", "UCHIDOMARI"));
        route28.addStop(new Stop("OJANA", "OJANA"));
        mRoutes.put(route28.getId(), route28);

        final Route route23 = createRoute("23", "琉球バス");
        route23.addStop(new Stop("SUNABE", "SUNABE"));
        route23.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        route23.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        route23.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        route23.addStop(new Stop("KADENA", "KADENA"));
        route23.addStop(new Stop("OWAN", "OWAN"));
        route23.addStop(new Stop("HIJA", "HIJA"));
        route23.addStop(new Stop("HIJAKUSHIBARU", "HIJAKUSHIBARU"));
        route23.addStop(new Stop("IRAMINA", "IRAMINA"));
        route23.addStop(new Stop("OKI", "OKI"));
        route23.addStop(new Stop("FURUGEN SHOGAKKO IRIGUCHI", "FURUGEN SHOGAKKO IRIGUCHI"));
        route23.addStop(new Stop("AKANUKUU MAE", "AKANUKUU MAE"));
        route23.addStop(new Stop("OZOE", "OZOE"));
        route23.addStop(new Stop("SOBE", "SOBE"));
        route23.addStop(new Stop("TOYA", "TOYA"));
        route23.addStop(new Stop("YOMITAN SHINRYOJO MAE", "YOMITAN SHINRYOJO MAE"));
        route23.addStop(new Stop("UFUDO", "UFUDO"));
        route23.addStop(new Stop("NAMIHIRA", "NAMIHIRA"));
        route23.addStop(new Stop("TAKASHIHO IRIGUCHI", "TAKASHIHO IRIGUCHI"));
        route23.addStop(new Stop("TAKASHIHO", "TAKASHIHO"));
        route23.addStop(new Stop("UZA KOMINKAN MAE", "UZA KOMINKAN MAE"));
        mRoutes.put(route23.getId(), route23);


        final Route a = createRoute("30", "琉球バス");
        a.addStop(new Stop("SUNABE", "SUNABE"));
        a.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        a.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        a.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        a.addStop(new Stop("KADENA", "KADENA"));
        a.addStop(new Stop("OWAN", "OWAN"));
        mRoutes.put(a.getId(), a);

        final Route b = createRoute("31", "琉球バス");
        b.addStop(new Stop("SUNABE", "SUNABE"));
        b.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        b.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        b.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        b.addStop(new Stop("KADENA", "KADENA"));
        b.addStop(new Stop("OWAN", "OWAN"));
        mRoutes.put(b.getId(), b);

        final Route c = createRoute("32", "琉球バス");
        c.addStop(new Stop("SUNABE", "SUNABE"));
        c.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        c.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        c.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        c.addStop(new Stop("KADENA", "KADENA"));
        c.addStop(new Stop("OWAN", "OWAN"));
        mRoutes.put(c.getId(), c);

        final Route d = createRoute("33", "琉球バス");
        d.addStop(new Stop("SUNABE", "SUNABE"));
        d.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        d.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        d.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        d.addStop(new Stop("KADENA", "KADENA"));
        d.addStop(new Stop("OWAN", "OWAN"));
        mRoutes.put(d.getId(), d);

        final Route e = createRoute("34", "琉球バス");
        e.addStop(new Stop("SUNABE", "SUNABE"));
        e.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        e.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        e.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        e.addStop(new Stop("KADENA", "KADENA"));
        e.addStop(new Stop("OWAN", "OWAN"));
        mRoutes.put(e.getId(), e);

        final Route f = createRoute("35", "琉球バス");
        f.addStop(new Stop("SUNABE", "SUNABE"));
        f.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        f.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        f.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        f.addStop(new Stop("KADENA", "KADENA"));
        f.addStop(new Stop("OWAN", "OWAN"));
        mRoutes.put(f.getId(), f);

        final Route g = createRoute("36", "琉球バス");
        g.addStop(new Stop("SUNABE", "SUNABE"));
        g.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        g.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        g.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        g.addStop(new Stop("KADENA", "KADENA"));
        g.addStop(new Stop("OWAN", "OWAN"));
        mRoutes.put(g.getId(), g);

        final Route h = createRoute("37", "琉球バス");
        h.addStop(new Stop("SUNABE", "SUNABE"));
        h.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        h.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        h.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        h.addStop(new Stop("KADENA", "KADENA"));
        h.addStop(new Stop("OWAN", "OWAN"));
        mRoutes.put(h.getId(), h);

        final Route i = createRoute("38", "琉球バス");
        i.addStop(new Stop("SUNABE", "SUNABE"));
        i.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        i.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        i.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        i.addStop(new Stop("KADENA", "KADENA"));
        i.addStop(new Stop("OWAN", "OWAN"));
        mRoutes.put(i.getId(), i);

        final Route j = createRoute("39", "琉球バス");
        j.addStop(new Stop("SUNABE", "SUNABE"));
        j.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        j.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        j.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        j.addStop(new Stop("KADENA", "KADENA"));
        j.addStop(new Stop("OWAN", "OWAN"));
        mRoutes.put(j.getId(), j);

        final Route k = createRoute("40", "琉球バス");
        k.addStop(new Stop("SUNABE", "SUNABE"));
        k.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        k.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        k.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        k.addStop(new Stop("KADENA", "KADENA"));
        k.addStop(new Stop("OWAN", "OWAN"));
        mRoutes.put(k.getId(), k);

        final Route l = createRoute("41", "琉球バス");
        l.addStop(new Stop("SUNABE", "SUNABE"));
        l.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        l.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        l.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        l.addStop(new Stop("KADENA", "KADENA"));
        l.addStop(new Stop("OWAN", "OWAN"));
        mRoutes.put(l.getId(), l);

        final Route m = createRoute("42", "琉球バス");
        m.addStop(new Stop("SUNABE", "SUNABE"));
        m.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        m.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        m.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        m.addStop(new Stop("KADENA", "KADENA"));
        m.addStop(new Stop("OWAN", "OWAN"));
        mRoutes.put(m.getId(), m);

        final Route n = createRoute("43", "琉球バス");
        n.addStop(new Stop("SUNABE", "SUNABE"));
        n.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        n.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        n.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        n.addStop(new Stop("KADENA", "KADENA"));
        n.addStop(new Stop("OWAN", "OWAN"));
        mRoutes.put(n.getId(), n);

        final Route o = createRoute("44", "琉球バス");
        o.addStop(new Stop("SUNABE", "SUNABE"));
        o.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        o.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        o.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        o.addStop(new Stop("KADENA", "KADENA"));
        o.addStop(new Stop("OWAN", "OWAN"));
        mRoutes.put(o.getId(), o);

        final Route p = createRoute("45", "琉球バス");
        p.addStop(new Stop("SUNABE", "SUNABE"));
        p.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        p.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        p.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        p.addStop(new Stop("KADENA", "KADENA"));
        p.addStop(new Stop("OWAN", "OWAN"));
        mRoutes.put(p.getId(), p);

        final Route q = createRoute("46", "琉球バス");
        q.addStop(new Stop("SUNABE", "SUNABE"));
        q.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        q.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        q.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        q.addStop(new Stop("KADENA", "KADENA"));
        q.addStop(new Stop("OWAN", "OWAN"));
        mRoutes.put(q.getId(), q);

        final Route r = createRoute("47", "琉球バス");
        r.addStop(new Stop("SUNABE", "SUNABE"));
        r.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        r.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        r.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        r.addStop(new Stop("KADENA", "KADENA"));
        r.addStop(new Stop("OWAN", "OWAN"));
        mRoutes.put(r.getId(), r);

        final Route s = createRoute("48", "琉球バス");
        s.addStop(new Stop("SUNABE", "SUNABE"));
        s.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        s.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        s.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        s.addStop(new Stop("KADENA", "KADENA"));
        s.addStop(new Stop("OWAN", "OWAN"));
        mRoutes.put(s.getId(), s);

        final Route t = createRoute("49", "琉球バス");
        t.addStop(new Stop("SUNABE", "SUNABE"));
        t.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
        t.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
        t.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
        t.addStop(new Stop("KADENA", "KADENA"));
        t.addStop(new Stop("OWAN", "OWAN"));
        mRoutes.put(t.getId(), t);

        for (int count = 50; count < 75; ++count) {
            final Route next = createRoute(count + "", "琉球バス");
            next.addStop(new Stop("SUNABE", "SUNABE"));
            next.addStop(new Stop("KAIHIN KOEN MAE", "KAIHIN KOEN MAE"));
            next.addStop(new Stop("MIZUGAMA", "MIZUGAMA"));
            next.addStop(new Stop("KADENACHO YAKUBA MAE", "KADENACHO YAKUBA MAE"));
            next.addStop(new Stop("KADENA", "KADENA"));
            next.addStop(new Stop("OWAN", "OWAN"));
            mRoutes.put(next.getId(), next);
        }
    }

    @Override
    public Route retrieveRouteById(String id) {
        return mRoutes.get(id);
    }

    @Override
    public void deleteRouteById(String id) {
        mRoutes.remove(id);
    }

    @Override
    public void updateRoute(Route route) {
        mRoutes.put(route.getId(), route);
    }

    @Override
    public void addRoute(Route route) {
        mRoutes.put(route.getId(), route);
    }

    @Override
    public List<Stop> searchStops(StopSearchCriteria criteria) {
        final List<Stop> stops = new ArrayList<Stop>();
        int limit = criteria.getLimit();
        String searchTerm = criteria.getStopName();
        int i = 0;
        for (final Stop stop : mStops) {
            if (stop.getName().toLowerCase()
                    .contains(searchTerm.toLowerCase())) {
                stops.add(stop);
                ++i;
            }
            if (i >= limit) {
                break;
            }
        }
        return stops;
    }

    @Override
    public List<Route> searchRoutes(final RouteSearchCriteria criteria) {

        int offset = criteria.getOffset();
        int limit  = criteria.getLimit();

        offset = offset > mRoutes.size() ? mRoutes.size() : offset;

        // Ideally this would come from a sorted source, so this sort
        // of code would not be needed.
        final List<Route> routes = new ArrayList(mRoutes.values());
        Collections.sort(routes, new Comparator<Route>() {
            @Override
            public int compare(Route lhs, Route rhs) {
                return lhs.getRouteName().compareTo(rhs.getRouteName());
            }
        });

        int count;
        if (offset + limit > mRoutes.size()) {
            count = mRoutes.size() - 1;
        } else {
            count = offset + limit;
        }
        return routes.subList(offset, count);
    }
}
