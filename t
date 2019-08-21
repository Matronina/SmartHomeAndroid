[1mdiff --git a/app/src/main/java/com/example/matronina/myproject/AlertsAdapter.java b/app/src/main/java/com/example/matronina/myproject/AlertsAdapter.java[m
[1mdeleted file mode 100644[m
[1mindex 36e5490..0000000[m
[1m--- a/app/src/main/java/com/example/matronina/myproject/AlertsAdapter.java[m
[1m+++ /dev/null[m
[36m@@ -1,44 +0,0 @@[m
[31m-package com.example.matronina.myproject.model;[m
[31m-[m
[31m-import android.content.Context;[m
[31m-import android.support.annotation.NonNull;[m
[31m-import android.support.v7.widget.RecyclerView;[m
[31m-import android.view.View;[m
[31m-import android.view.ViewGroup;[m
[31m-import android.widget.TextView;[m
[31m-[m
[31m-import java.util.List;[m
[31m-[m
[31m-public class AlertsAdapter extends RecyclerView.Adapter<AlertsAdapter.MyViewHolder> {[m
[31m-    private Context context;[m
[31m-    private List<Alert> alertsList;[m
[31m-[m
[31m-    public class MyViewHolder extends RecyclerView.ViewHolder {[m
[31m-        public TextView note;[m
[31m-        public TextView dot;[m
[31m-        public TextView timestamp;[m
[31m-[m
[31m-        public MyViewHolder(View view) {[m
[31m-            super(view);[m
[31m-//            note = view.findViewById(R.id.note);[m
[31m-//            dot = view.findViewById(R.id.dot);[m
[31m-//            timestamp = view.findViewById(R.id.timestamp);[m
[31m-        }[m
[31m-    }[m
[31m-[m
[31m-    @NonNull[m
[31m-    @Override[m
[31m-    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {[m
[31m-        return null;[m
[31m-    }[m
[31m-[m
[31m-    @Override[m
[31m-    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {[m
[31m-[m
[31m-    }[m
[31m-[m
[31m-    @Override[m
[31m-    public int getItemCount() {[m
[31m-        return 0;[m
[31m-    }[m
[31m-}[m
