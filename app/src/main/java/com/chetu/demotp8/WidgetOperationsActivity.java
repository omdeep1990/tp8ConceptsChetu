package com.chetu.demotp8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

import com.chetu.demotp8.databinding.ActivityWidgetOperationsBinding;
import com.chetu.demotp8.databinding.CustomListviewExampleBinding;
import com.chetu.demotp8.databinding.ListViewLayoutBinding;
import com.google.gson.Gson;

import java.util.ArrayList;

public class WidgetOperationsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, View.OnClickListener {
    private ActivityWidgetOperationsBinding binding;
    private final String[] countries = new String[]{"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe", "Palestine"};
    private final String[] monthName = new String[]{"Please Select Month Name", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    Dialog dialog;
    Window window;
    CustomListviewExampleBinding exampleBinding;
    private ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWidgetOperationsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userList = new ArrayList<>();
//TODO: For all autocomplete textViews, multi-autocomplete textViews, spinner, listViews we have to set adapter either hardcoded or by making custom adapter
        //TODO: For Auto Complete TextViews and MultiAutoComplete TextViews: -
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);
        binding.autoCompleteTextView.setAdapter(adapter);

        //TODO: For Spinner adapter: -
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, monthName);
        binding.spinner.setAdapter(spinnerAdapter);

        binding.multiAutoCmtTxtView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        binding.multiAutoCmtTxtView.setAdapter(adapter);

        binding.autoCompleteTextView.setOnItemClickListener(this);
        binding.multiAutoCmtTxtView.setOnItemClickListener(this);


        binding.spinner.setOnItemSelectedListener(this);

        //TODO: ListView has two ClickListeners: OnItemClickListener and OnLongClickListener
        binding.listViewBtn.setOnClickListener(this);
        binding.customListView.setOnClickListener(this);

        dialog = new Dialog(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.listView_btn:
                ListViewLayoutBinding layoutBinding = ListViewLayoutBinding.inflate(getLayoutInflater());
                ArrayAdapter<String> listViewAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, monthName);
                layoutBinding.listView.setAdapter(listViewAdapter);

//                dialog = new Dialog(this);
                dialog.setContentView(layoutBinding.getRoot());
                dialog.setCancelable(false);
                dialog.show();
                window = dialog.getWindow();
                window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                //TODO: ListView has two ClickListeners: OnItemClickListener and OnLongClickListener
                layoutBinding.listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Util.customToast(WidgetOperationsActivity.this, adapterView.getItemAtPosition(position).toString());
                        dialog.dismiss();
                        return false;
                    }
                });
                layoutBinding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Util.customToast(WidgetOperationsActivity.this, adapterView.getItemAtPosition(position).toString());
                        dialog.dismiss();
                    }
                });
                break;

            case R.id.custom_list_view:
                exampleBinding = CustomListviewExampleBinding.inflate(getLayoutInflater());
                dialog.setContentView(exampleBinding.getRoot());
                dialog.setCancelable(false);
                dialog.show();
                window = dialog.getWindow();
                window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                exampleBinding.closeBtnImage.setOnClickListener(this);
                exampleBinding.submitBtn.setOnClickListener(this);
                exampleBinding.sendBtn.setOnClickListener(this);
                break;

            case R.id.close_btn_image:
                dialog.dismiss();
                break;

            case R.id.submit_btn:
                User user = new User();
                user.setFirstName(exampleBinding.firstName.getText().toString());
                user.setLastName(exampleBinding.lastName.getText().toString());
                user.setMobileNo(exampleBinding.mobileNo.getText().toString());
                userList.add(user);
                break;

            case R.id.send_btn:
                //TODO: To show the data in listView: -
                Intent intent = new Intent(this, ListViewActivity.class);
                //TODO: 1. We can send data by making it serializable also: -
//                intent.putExtra("user_List", userList);

                //TODO: 2. This is the second method to send data using
                intent.putExtra("user_List", new Gson().toJson(userList));
                startActivity(intent);

        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        if (binding.autoCompleteTextView.getId() == R.id.auto_complete_text_view) {
            String countryName = adapterView.getItemAtPosition(position).toString();
            Util.customToast(WidgetOperationsActivity.this, countryName);
        } else {
            String countryName = adapterView.getItemAtPosition(position).toString();
            Util.customToast(WidgetOperationsActivity.this, countryName);
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String months = adapterView.getItemAtPosition(position).toString();
        Util.customToast(WidgetOperationsActivity.this, months);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}