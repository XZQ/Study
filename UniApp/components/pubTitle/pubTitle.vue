<template>
	<view class="pubTile">
		<view class="big">{{title}}</view>
		<view class="small">{{subTitle}}</view>
		<view class="line"></view>
	</view>
</template>

<script>
	export default {
		name: "pubTitle",
		data() {
			return {

			};
		},
		props: {
			title: {
				type: String,
				default: "默认标题"
			},
			subTitle: {
				type: String,
				default: "默认子标题"
			}
		}
	}
</script>

<style lang="scss">
	.pubTile {
		padding: 60rpx 30rpx;
		text-align: center;
		background: #B9EDF8;

		.big {
			font-size: 50rpx;
			font-weight: 600;
			color: #1F6ED4;
		}

		.small {
			font-size: 28rpx;
			color: #39bae8;
		}

		.line {
			display: inline-block;
			width: 100rpx;
			height: 10rpx;
			background: #0000a1;
			border-radius: 10rpx;
		}
	}
</style>