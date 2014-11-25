package org.bbs.osgi.activity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 *  all method will call through {@link #mTargetActivity}, so, we can
 *  "embed' an exist activity to {@link BundleActivity}.
 * @author luoqii
 *
 */
public abstract class EmbeddedActivityAgent extends ActivityAgent {
	private static final String TAG = EmbeddedActivityAgent.class.getSimpleName();
	
	protected Activity mTargetActivity;
	
	public abstract Activity getTargetActivity();
	
	protected void onCreate(Bundle savedInstanceState) {
		mTargetActivity = getTargetActivity();
		ActivityUtil.attachBaseContext(mTargetActivity, mHostActivity.getApplication());
		ActivityUtil.copyFields(mHostActivity, mTargetActivity);
		ActivityUtil.onCreate(mTargetActivity, savedInstanceState);
	}
	
	protected void onResume() {
	}

	protected void onPause() {
	}

	protected void onDestroy() {
		super.onDestroy();
	}
	
	
	public boolean onPreparePanel(int arg0, View arg1, Menu arg2) {
		return mTargetActivity.onPreparePanel(arg0, arg1, arg2);
	}
	public boolean onPrepareOptionsMenu(Menu menu) {
		return mTargetActivity.onPrepareOptionsMenu(menu);
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		return mTargetActivity.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return mTargetActivity.onOptionsItemSelected(item);
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		mTargetActivity.onCreateContextMenu(menu, v, menuInfo);
	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		return mTargetActivity.onContextItemSelected(item);
	}
	@Override
	public void onContextMenuClosed(Menu menu) {
		mTargetActivity.onContextMenuClosed(menu);
	}

	public void onActivityResult(int arg0, int arg1, Intent arg2) {
		ActivityUtil.onActivityResult(mTargetActivity, arg0, arg1, arg2);
	}
	
	static class ActivityUtil {
		public static void onCreate(Activity activity, Bundle savedInstanceState){
			try {
				Method m = Activity.class.getDeclaredMethod("onCreate", new Class[]{Bundle.class});
				m.setAccessible(true);
				m.invoke(activity, new Object[]{savedInstanceState});
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		public static void onContextMenuClosed(Activity activity,
				Menu menu) {
			try {
				Method m = Activity.class.getDeclaredMethod("onContextMenuClosed", new Class[]{Menu.class});
				m.setAccessible(true);
				m.invoke(activity, new Object[]{menu});
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}


		public static boolean onContextItemSelected(Activity activity,
				MenuItem item) {
			try {
				Method m = Activity.class.getDeclaredMethod("onContextItemSelected", new Class[]{MenuItem.class});
				m.setAccessible(true);
				return (Boolean) m.invoke(activity, new Object[]{item});
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return false;
		}


		public static void onCreateContextMenu(Activity activity,
				ContextMenu menu, View v, ContextMenuInfo menuInfo) {
			try {
				Method m = Activity.class.getDeclaredMethod("onCreateContextMenu", new Class[]{ContextMenu.class, View.class, ContextMenuInfo.class});
				m.setAccessible(true);
				m.invoke(activity, new Object[]{menu, v, menuInfo});
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}


		public static void onActivityResult(Activity activity, int arg0,
				int arg1, Intent arg2) {
			try {
				Method m = Activity.class.getDeclaredMethod("onActivityResult", new Class[]{int.class, int.class, Intent.class});
				m.setAccessible(true);
				m.invoke(activity, new Object[]{arg0, arg1, arg2});
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}


		public static boolean onOptionsItemSelected(Activity activity, MenuItem item) {
			try {
				Method m = Activity.class.getDeclaredMethod("onOptionsItemSelected", new Class[]{MenuItem.class});
				m.setAccessible(true);
				return (Boolean) m.invoke(activity, new Object[]{item});
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}

		public static boolean onCreateOptionsMenu(Activity activity, Menu menu) {
			try {
				Method m = Activity.class.getDeclaredMethod("onCreateOptionsMenu", new Class[]{Menu.class});
				return (Boolean) m.invoke(activity, new Object[]{menu});
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		

		public static void attachBaseContext(Activity activity,
				Application application) {
			try {
				Method m = ContextWrapper.class.getDeclaredMethod("attachBaseContext", new Class[]{Context.class});
				m.setAccessible(true);
				m.invoke(activity, new Object[]{application});
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}


		public static void copyFields(Activity host, Activity target) {
		    String[] fields = new String[] {
		            "mMainThread",
		            "mInstrumentation",
		            "mToken",
		            "mIdent",
		            "mApplication",
		            "mIntent",
		            "mActivityInfo",
		            "mTitle",
		            "mParent",
		            "mEmbeddedID",
		            "mLastNonConfigurationInstances",
		            "mFragments",// java.lang.IllegalStateException
		                         // FragmentManagerImpl.moveToState
		            "mWindow",
		            "mWindowManager",
		            "mCurrentConfig"
		    };
		    copyFields(Activity.class, fields, host, target);
		    
		    fields = new String[] {
//		    		"mBase", // android.content.ContextWrapper
		    };
		    copyFields(ContextWrapper.class, fields, host, target);
		}


		public static void copyFields(Class clazz, String[] fields, Activity host, Activity target) {

		    try {
		        for (String f : fields) {
		            Field declaredField = clazz.getDeclaredField(f);
		            setField(target, declaredField, getFiledValue(host, f));
		        }
		    } catch (NoSuchFieldException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		}

		public static  void setField(Object object, Field field, Object value) {
		    field.setAccessible(true);
		    try {
		        field.set(object, value);
		    } catch (IllegalArgumentException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    } catch (IllegalAccessException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		}

		public static  Object getFiledValue(Object object, String fieldName) {
		        Object f = null;
		        try {
		            Class<?> ACTIVITY = Class.forName("android.app.Activity");
		            Field declaredField = ACTIVITY.getDeclaredField(fieldName);
		            declaredField.setAccessible(true);
		            f = declaredField.get(object);
		        } catch (ClassNotFoundException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (NoSuchFieldException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (IllegalArgumentException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (IllegalAccessException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		
		//        Log.d(TAG, "getFiledValue(). fieldName: " + fieldName + " field: " + f);
		        return f;
		    }
	}
	
	
}
