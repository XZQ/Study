<template>
	<view>
		<pubTitle title="" title=""></pubTitle>
		<view class="out">
			<!-- <view class="box"></view>
				<view class="block"></view> -->
			<icon type="search" size="26"></icon>
			<icon type="waiting"></icon>
			<view>uniapp</view>
			<text>nodejs</text>

			<view>--------------------v-form----------------</view>

			<scroll-view class="scroll" scroll-x="true" scroll-y="true">
				<view class="group">
					<view class="item">111</view>
					<view class="item">222</view>
					<view class="item">333</view>
					<view class="item">444</view>
					<view class="item">555</view>
					<view class="item">555</view>
					<view class="item">555</view>
					<view class="item">555</view>
					<view class="item">555</view>
					<view class="item">555</view>
				</view>
			</scroll-view>
		</view>
	</view>

</template>

<script>
	export default {
		data() {
			return {
				title: "XZQ"
			};
		}
	}
</script>

<style lang="scss">
	.scroll {
		border: 1px solid red;
		height: 200rpx;
		box-sizing: border-box;

		.group {
			white-space: nowrap;

			.item {
				width: 200rpx;
				height: 200rpx;
				background: rosybrown;
				display: inline-block;
				margin-left: 10px;
			}
		}
	}

	.swiper {
		height: 400rpx;
		margin-top: 10rpx;

		.item {
			image {
				width: 100%;
				height: 400rpx;
			}
		}
	}
</style>