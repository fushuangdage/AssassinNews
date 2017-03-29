package com.fushuang.assassinnews.View.activity;

import android.os.Handler;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import android.view.WindowManager;
import android.widget.EditText;

import android.widget.Toast;

import com.fushuang.assassinnews.R;
import com.fushuang.assassinnews.adapter.ChatAdapter;
import com.fushuang.assassinnews.model.ImMsg;
import com.fushuang.assassinnews.xmpp.XmppConnection;
import com.fushuang.assassinnews.xmpp.XmppLoadThread;


import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ChatManagerListener;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class IMActivity extends BaseActivity {

    private IMActivity mActivity;
    @BindView(R.id.input)
    EditText mEditText;
    @BindView(R.id.recycle_view)
    RecyclerView mRecyclerView;

    List<ImMsg> mList=new ArrayList<>();
    private ChatAdapter mChatAdapter;
    Handler mHandler=new Handler(){
        @Override
        public void dispatchMessage(android.os.Message msg) {
            super.dispatchMessage(msg);
            ImMsg imMsg = (ImMsg) msg.obj;
            mList.add(imMsg);
            mChatAdapter.notifyItemInserted(mList.size());
        }
    };
    @Override
    protected void initInject() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_im;
    }

    @Override
    protected void init() {
        mActivity=this;
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        new Thread(){
            @Override
            public void run() {
                super.run();
                XmppConnection.getInstance().getConnection().getChatManager().addChatListener(new ChatManagerListener() {
                    @Override
                    public void chatCreated(Chat chat, boolean b) {
                        chat.addMessageListener(new MessageListener() {
                            @Override
                            public void processMessage(Chat chat, Message message) {
                                Log.d("connectMethod:", message.getBody() + message.getFrom());
                                ImMsg imMsg = new ImMsg(message.getFrom(), message.getTo(), message.getBody());
                                mHandler.sendMessage(mHandler.obtainMessage(1,imMsg));
                            }
                        });
                    }
                });
            }
        }.start();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
        mChatAdapter = new ChatAdapter(this, mList);
        mChatAdapter.addItemViewDelegate(new ChatAdapter.MsgInItemDelagate());
        mChatAdapter.addItemViewDelegate(new ChatAdapter.MsgComeItemDelagate());

        mRecyclerView.setAdapter(mChatAdapter);
    }

    @OnClick({R.id.send,R.id.login})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                new XmppLoadThread(this){
                    @Override
                    protected Object load() {
                        boolean login = XmppConnection.getInstance().login("fushuang", "123");
                        return login;
                    }

                    @Override
                    protected void result(Object object) {
                        boolean isSuccess = (boolean) object;
                        if (isSuccess){
                            Toast.makeText(mActivity,"登录成功",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(mActivity,"登录失败",Toast.LENGTH_SHORT).show();
                        }
                    }
                };
                break;

            case R.id.send:
                XMPPConnection connection = XmppConnection.getInstance().getConnection();
                ChatManager chatManager = connection.getChatManager();
                Chat chat = chatManager.createChat("fushuang@45.248.84.87", null);
                try {
                    chat.sendMessage(mEditText.getText().toString());
                    ImMsg imMsg = new ImMsg("me", "fushuang@45.248.84.87", mEditText.getText().toString());
                    mList.add(imMsg);
                    mChatAdapter.notifyDataSetChanged();
                } catch (XMPPException e) {
                    e.printStackTrace();
                }
                break;

        }
    }

    @Override
    public void showError(String msg) {

    }
}
