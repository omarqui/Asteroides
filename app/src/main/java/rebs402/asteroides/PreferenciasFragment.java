package rebs402.asteroides;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.widget.Toast;

/**
 * Created by Usuario on 15/7/2017.
 */

public class PreferenciasFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);

        final EditTextPreference fragmentosPref = (EditTextPreference)findPreference("fragmentos");

        fragmentosPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
//                if (newValue.toString().length() == 15) {
//                    //
//                    return true;
//                }
//                else{
//                    // invalid you can show invalid message
//                    return false;
//                  }
                return true;
            }
        });
    }
}
