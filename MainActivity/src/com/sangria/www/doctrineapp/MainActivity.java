package com.sangria.www.doctrineapp;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
	
  
    AppSectionsPagerAdapter mAppSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will display the three primary sections of the app, one at a
     * time.
     */
    ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

        // Create the adapter that will return a fragment for each of the three primary sections
        // of the app.
        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());

        // Set up the action bar.
        final ActionBar actionBar = getActionBar();

        // Specify that the Home/Up button should not be enabled, since there is no hierarchical
        // parent.
        actionBar.setHomeButtonEnabled(false);

        // Specify that we will be displaying tabs in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Set up the ViewPager, attaching the adapter and setting up a listener for when the
        // user swipes between sections.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // When swiping between different app sections, select the corresponding tab.
                // We can also use ActionBar.Tab#select() to do this if we have a reference to the
                // Tab.
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mAppSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by the adapter.
            // Also specify this Activity object, which implements the TabListener interface, as the
            // listener for when this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mAppSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
    	// The action bar home/up action should open or close the drawer.
    	// ActionBarDrawerToggle will take care of this.
    	// Handle action buttons
    	int position;

    	switch(item.getItemId()) {
    	
    	case R.id.menu_home:

    		position = 0;

    		mViewPager.setCurrentItem(position);

    		return true;

    	default:
    		position = 0;

    		mViewPager.setCurrentItem(position);
    		
    		return true;
    		
    	}
    	
    }
    			
    			
    
    public void sendEmail(View view){
    	
    	final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

    	emailIntent.setType("text/plain");
    	emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"thesangriadoctrine@gmail.com"});
    	emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "A question for my friends of The Sangria Doctrine lecture series");
    	emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");

    	this.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
    	
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the primary
     * sections of the app.
     */
    public class AppSectionsPagerAdapter extends FragmentPagerAdapter {

        public AppSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    // The first section of the app is the most interesting -- it offers
                    // a launchpad into the other demonstrations in this example application.
                    return new LaunchpadSectionFragment();
                    
                case 1:
                	return new DoctrineSectionFragment();
                	
                case 2:
                	return new UpcomingSectionFragment();
                	
                case 3:
                	return new HumeSectionFragment();
                	
                case 4:
                	return new SambergSectionFragment();
                	
                case 5:
                	return new BergstonSectionFragment();
                	
                case 6:
                	return new AskSectionFragment();

                default:
                    // The other sections of the app are dummy placeholders.
                    Fragment fragment = new DummySectionFragment();
                    Bundle args = new Bundle();
                    args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, i + 1);
                    fragment.setArguments(args);
                    return fragment;
            }
        }

        @Override
        public int getCount() {
            return 7;
        }

        @Override
        public CharSequence getPageTitle(int position) {
        	switch(position) {
        		case 0:
        			return getString(R.string.section_1_title);
        		case 1:
        			return getString(R.string.section_2_title);
        		case 2:
        			return getString(R.string.section_3_title);
        		case 3:
        			return getString(R.string.section_4_title);
        		case 4:
        			return getString(R.string.section_5_title);
        		case 5:
        			return getString(R.string.section_6_title);
        		default:
        			return getString(R.string.section_7_title);
        				
        			
        	}
        		
        }
    }

    /**
     * A fragment that launches other parts of the demo application.
     */
    public static class LaunchpadSectionFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_section_launchpad, container, false);

           /* // Demonstration of a collection-browsing activity.
            rootView.findViewById(R.id.demo_collection_button)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), CollectionDemoActivity.class);
                            startActivity(intent);
                        }
                    });

            // Demonstration of navigating to external activities.
            rootView.findViewById(R.id.demo_external_activity)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // Create an intent that asks the user to pick a photo, but using
                            // FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET, ensures that relaunching
                            // the application from the device home screen does not return
                            // to the external activity.
                            Intent externalActivityIntent = new Intent(Intent.ACTION_PICK);
                            externalActivityIntent.setType("image/*");
                            externalActivityIntent.addFlags(
                                    Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                            startActivity(externalActivityIntent);
                        }
                    });*/

            return rootView;
        }
    }
    
    public static class DoctrineSectionFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_section_doctrine, container, false);
            return rootView;
        }
    }
    
    public static class UpcomingSectionFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_section_upcoming, container, false);
            return rootView;
        }
    }
    
    public static class HumeSectionFragment extends Fragment {

    	
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_section_bio, container, false);
            
    		//set text/image fields
    		TextView titleText = (TextView)rootView.findViewById(R.id.bio_title);
    		titleText.setText(getString(R.string.hume_title));
    		
    		TextView firstText = (TextView)rootView.findViewById(R.id.bio_first_text);
    		firstText.setText(getString(R.string.hume_first_text));
    		
    		TextView secondText = (TextView)rootView.findViewById(R.id.bio_second_text);
    		secondText.setText(getString(R.string.hume_second_text));
    		
    		TextView thirdText = (TextView)rootView.findViewById(R.id.bio_third_text);
    		thirdText.setText(getString(R.string.hume_third_text));
    		
    		ImageView firstImage = (ImageView)rootView.findViewById(R.id.bio_image_1);
    		firstImage.setImageDrawable(getResources().getDrawable(R.drawable.hume));
    		
    		return rootView;
    	}

    }

    
    public static class SambergSectionFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_section_bio, container, false);
            
          //set text/image fields
    		TextView titleText = (TextView)rootView.findViewById(R.id.bio_title);
    		titleText.setText(getString(R.string.samberg_title));
    		
    		TextView firstText = (TextView)rootView.findViewById(R.id.bio_first_text);
    		firstText.setText(getString(R.string.samberg_first_text));
    		
    		TextView secondText = (TextView)rootView.findViewById(R.id.bio_second_text);
    		secondText.setText(getString(R.string.samberg_second_text));
    		
    		TextView thirdText = (TextView)rootView.findViewById(R.id.bio_third_text);
    		thirdText.setText(getString(R.string.samberg_third_text));
    		
    		ImageView firstImage = (ImageView)rootView.findViewById(R.id.bio_image_1);
    		firstImage.setImageDrawable(getResources().getDrawable(R.drawable.samberg));
    		
    		return rootView;
            
        }
    }
    
    public static class BergstonSectionFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_section_bio, container, false);
            
          //set text/image fields
    		TextView titleText = (TextView)rootView.findViewById(R.id.bio_title);
    		titleText.setText(getString(R.string.bergston_title));
    		
    		TextView firstText = (TextView)rootView.findViewById(R.id.bio_first_text);
    		firstText.setText(getString(R.string.bergston_first_text));
    		
    		TextView secondText = (TextView)rootView.findViewById(R.id.bio_second_text);
    		secondText.setText(getString(R.string.bergston_second_text));
    		
    		TextView thirdText = (TextView)rootView.findViewById(R.id.bio_third_text);
    		thirdText.setText(getString(R.string.bergston_third_text));
    		
    		ImageView firstImage = (ImageView)rootView.findViewById(R.id.bio_image_1);
    		firstImage.setImageDrawable(getResources().getDrawable(R.drawable.bergston));
    		
    		return rootView;
        }
    }
    
    public static class AskSectionFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_section_ask, container, false);
            return rootView;
        }
        
        
    }
    
    /**
     * A dummy fragment representing a section of the app, but that simply displays dummy text.
     */
    public static class DummySectionFragment extends Fragment {

        public static final String ARG_SECTION_NUMBER = "section_number";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_section_dummy, container, false);
            Bundle args = getArguments();
            ((TextView) rootView.findViewById(android.R.id.text1)).setText(
                    getString(R.string.dummy_section_text, args.getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }
}
