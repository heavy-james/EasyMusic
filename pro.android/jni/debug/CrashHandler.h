#ifndef __CRASH_HANDLER__
#define __CRASH_HANDLER__

#ifndef __SIZE_TYPE__
#define __SIZE_TYPE__ long unsigned int
#endif
#if !(defined (__GNUG__) && defined (size_t))
typedef __SIZE_TYPE__ size_t;
#endif

#include <signal.h>
#include<jni.h>

/*
 struct sigaction
 {
 void (*sa_handler)(int);
 void (*sa_sigaction)(int ,siginfo_t *, void *);
 sigset_t sa_mask;
 int sa_flags;
 void (*sa_restorer)(void);
 };
 */

int sigaction(int signum, const struct sigaction* act,
		struct sigaction* oldact);

const int handledSignals[] = { SIGSEGV, SIGABRT, SIGFPE, SIGILL, SIGBUS };

const int handledSignalsNum = sizeof(handledSignals)
		/ sizeof(handledSignals[0]);

struct sigaction old_handlers[handledSignalsNum];
void* memset(void *, int, size_t);

JavaVM* g_jvm;

JNIEnv* JNI_GetEnv()

{
	JNIEnv* env;
	g_jvm->GetEnv((void**) &env, JNI_VERSION_1_2);
	return env;
}

void my_sigaction(int signal, siginfo_t *info, void *reserved) {
		jclass crashHandlerClass = JNI_GetEnv()->FindClass(
				"develop/wiki/android/global/debug/CrashHandler");
		jmethodID notifyNativeCrash = JNI_GetEnv()->GetStaticMethodID(crashHandlerClass,
				"notifyNativeCrash", "()V");
		JNI_GetEnv()->CallStaticVoidMethod(crashHandlerClass, notifyNativeCrash);
}

int nativeCrashHandler_onLoad() {

	struct sigaction handler;
	memset(&handler, 0, sizeof(handler));
	handler.sa_sigaction = my_sigaction;
	handler.sa_flags = SA_RESTART | SA_SIGINFO;
	sigemptyset(&handler.sa_mask);
	for (int i = 0; i < handledSignalsNum; ++i) {
		sigaction(handledSignals[i], &handler, &old_handlers[i]);
	}
	return 0;
}

#endif
